package com.zhudengkui.helloworld.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhudengkui.helloworld.user.entity.User;
import com.zhudengkui.helloworld.user.entity.UserVo;
import com.zhudengkui.helloworld.user.service.UserService;
import com.zhudengkui.helloworld.util.aware.MyBeanFactoryAwareUtil;
import org.springframework.beans.factory.InitializingBean;

/**
 * <b>类 名 称</b> :  ApplicationContextTest<br/>
 * <b>类 描 述</b> :  获取spring容器测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 20:30<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 20:30<br/>
 * <b>修改备注</b> :  完全独立于spring工程的main方法是无论如何也获取不到spring容器的
 * @author z_dk
 */
public class ApplicationContextTest implements InitializingBean {
    
    public static void main(String[] args) {
        beanFactoryTest();
    }
    
    private static void beanFactoryTest() {
        UserService userService = MyBeanFactoryAwareUtil.getBean(UserService.class);
        Page<User> page = userService.pageUserByParam(new UserVo());
        System.out.println(page.getPages());
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializing ... afterPropertiesSet");
    }
}
