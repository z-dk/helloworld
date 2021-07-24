package junit;

import com.zdk.hello.HelloworldApplication;
import com.zdk.hello.service.role.service.RoleService;
import com.zdk.hello.service.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>类 名 称</b> :  DataBaseTest<br/>
 * <b>类 描 述</b> :  数据库访问测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 10:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 10:02<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloworldApplication.class})
public class DataBaseTest {
    
    @Resource
    UserService userService;
    
    @Resource
    RoleService roleService;

    /**
     * 测试多数据源频繁切换的场景
     * 实现多数据源的方式:
     * Spring-AOP:
     *      自定义注解(指明数据源),
     *      定义通知(执行请求前和请求后的数据源的切换操作),
     *      定义切面(定义切点+引入对应的通知),使用注解将其注入spring容器中生效
     * 数据源:
     *      使用 ThreadLocal存储当前使用的数据源,aop通过操作在threadLocal中存储的变量实现其切换
     *      继承抽象类AbstractRoutingDataSource自定义多数据源类来保存多个数据源
     *      自定义SqlSessionFactory来配置数据源为自定义是多数据源,这里使用的是mybatisPlus推荐的MybatisSqlSessionFactoryBean
     * @see ThreadLocal
     * @throws InterruptedException 中断异常
     */
    @Test
    public void dataCURD() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(() -> {
            for (;;) {
                userService.getUserById("1");
                System.out.println("user");
            }
        });
        threadPool.submit(() -> {
            for (;;) {
                roleService.getRoleById("1");
                System.out.println("role");
            }
        });
        do {
            System.out.println("waitting...");
            Thread.sleep(5000);
        } while (!threadPool.isTerminated());
        System.out.println("terminated");
    }
    
    
}
