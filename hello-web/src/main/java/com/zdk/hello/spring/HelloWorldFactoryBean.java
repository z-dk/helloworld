package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  HelloWorldFactoryBean<br/>
 * <b>类 描 述</b> :  fb<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/15 15:29<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/15 15:29<br/>
 * <b>修改备注</b> :  <br/>
 * 该bean会有两个bean对象
 * 1.工厂bean(&helloWorldFactoryBean):HelloWorldFactoryBean=object
 * 2.工厂构建的bean(helloWorldFactoryBean):Integer=100
 * @author zdk
 */
@Component
public class HelloWorldFactoryBean implements FactoryBean<Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldFactoryBean.class);

    @Value("${server.port}")
    private Integer port;
    
    /**
     * 该bean的name为helloWorldFactoryBean
     * @return bean对象
     */
    @Override
    public Integer getObject() {
        return port;
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
    
}
