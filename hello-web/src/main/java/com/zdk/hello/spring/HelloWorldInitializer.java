package com.zdk.hello.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 因为这时候spring容器还没被初始化，所以想要自己的扩展的生效，有以下三种方式：<br/>
 * 1.在启动类中用springApplication.addInitializers(new TestApplicationContextInitializer())语句加入<br/>
 * 2.配置文件配置context.initializer.classes=com.example.demo.TestApplicationContextInitializer<br/>
 * 3.Spring SPI扩展，在spring.factories中加入org.springframework.context.ApplicationContextInitializer=com.zdk.hello.spring.HelloWorldInitializer
 * @author zdk
 */
public class HelloWorldInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        //configurableApplicationContext.addBeanFactoryPostProcessor();
    }

}
