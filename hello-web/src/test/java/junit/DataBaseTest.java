package junit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zdk.hello.HelloworldApplication;
import com.zdk.hello.service.role.entity.Role;
import com.zdk.hello.service.role.service.RoleService;
import com.zdk.hello.service.user.entity.User;
import com.zdk.hello.service.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
    
    @Test
    public void dataCURD() {
        User user = userService.getUserById("1");
        System.out.println(JSON.toJSONString(user, SerializerFeature.PrettyFormat));

        Role role = roleService.getById("1");
        System.out.println(JSON.toJSONString(role, SerializerFeature.PrettyFormat));
    }
    
    
}
