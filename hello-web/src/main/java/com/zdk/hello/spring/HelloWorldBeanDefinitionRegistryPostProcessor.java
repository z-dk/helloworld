package com.zdk.hello.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * 在读取项目中的beanDefinition之后执行,可以在这里动态注册自己的beanDefinition，可以加载classpath之外的bean
 * @author zdk
 */
public class HelloWorldBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("beanDefinitionCount is " + beanDefinitionRegistry.getBeanDefinitionCount());
        //BeanDefinition beanDefinition =
        //beanDefinitionRegistry.registerBeanDefinition("beanName", null);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //configurableListableBeanFactory.
    }
}
