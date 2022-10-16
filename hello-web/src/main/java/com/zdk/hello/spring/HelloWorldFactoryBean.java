package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  HelloWorldFactoryBean<br/>
 * <b>类 描 述</b> :  fb<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/15 15:29<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/15 15:29<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Component
public class HelloWorldFactoryBean implements FactoryBean<Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldFactoryBean.class);

    @Override
    public Integer getObject() {
        return 100;
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
