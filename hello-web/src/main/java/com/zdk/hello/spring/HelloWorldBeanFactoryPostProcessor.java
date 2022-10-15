package com.zdk.hello.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * beanFactory的扩展接口，调用时机在spring在读取beanDefinition信息之后，实例化bean之前<br/>
 * 以通过实现这个扩展接口来自行处理一些东西，比如修改已经注册的beanDefinition的元信息。
 * @author zdk
 */
public class HelloWorldBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 可修改已注册的beanDefinition元信息
        beanFactory.getBeanDefinition("beanName");
    }
}
