package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 在读取项目中的beanDefinition之后执行,可以在这里动态注册自己的beanDefinition，可以加载classpath之外的bean
 * @author zdk
 */
@Component("bdRegistry")
public class HelloWorldBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldBeanDefinitionRegistryPostProcessor.class);

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //System.out.println("beanDefinitionCount is " + beanDefinitionRegistry.getBeanDefinitionCount());
        //BeanDefinition beanDefinition =
        //beanDefinitionRegistry.registerBeanDefinition("beanName", null);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //configurableListableBeanFactory.
    }
}
