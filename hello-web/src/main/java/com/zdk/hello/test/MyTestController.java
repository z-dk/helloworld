package com.zdk.hello.test;

import com.zdk.hello.service.MyBeanFactoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <b>类 名 称</b> :  MyTestController<br/>
 * <b>类 描 述</b> :  测试使用Controller<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 21:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 21:32<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@RestController
@RequestMapping("myTest")
public class MyTestController {
    
    @Resource
    MyBeanFactoryService factoryService;
    
    @RequestMapping("getBeanFactory")
    public Object getBeanFactory() {
        return factoryService.getFactoryBean();
    }
    
}
