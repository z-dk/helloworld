package web;

import com.zdk.hello.HelloworldApplication;
import com.zdk.hello.service.role.entity.Role;
import com.zdk.hello.service.role.service.RoleService;
import com.zdk.hello.service.user.entity.User;
import com.zdk.hello.service.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloworldApplication.class)
public class ServiceTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTest.class);

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Test
    public void test() {
        // 通过配置文件方式获取数据源，且配置文件中配置了多个数据源，且配置了分库分表，且配置了读写分离，且配置了分布式事务
        User user = userService.getUserById("1");
        Role role = roleService.getRoleById("1");
        LOGGER.info("user:{}", user);
        LOGGER.info("role:{}", role);
    }

}
