package com.zdk.hello.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * <b>类 名 称</b> :  MyBeanFactoryService<br/>
 * <b>类 描 述</b> :  自定义beanFactory<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 21:29<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 21:29<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Service
public class MyBeanFactoryService implements BeanFactoryAware {
    
    private BeanFactory beanFactory;
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    
    public Object getFactoryBean() {
        Object myFactoryBean = beanFactory.getBean("myFactoryBean");
        System.out.println(myFactoryBean);
        Object factory = beanFactory.getBean("&myFactoryBean");
        System.out.println(factory);
        return factory;
    }
}
