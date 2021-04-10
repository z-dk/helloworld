package com.zhudengkui.helloworld.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <b>类 名 称</b> :  MyBeanFactoryPostProccesor<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/3/21 10:44<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/3/21 10:44<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("");
        beanDefinition.setRole(1);
    }
}
