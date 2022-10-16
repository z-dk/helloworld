package com.zdk.hello.spring;

import com.zdk.hello.service.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
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
        AbstractBeanDefinition userBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("id", 12345)
                .addPropertyValue("name", "zdy")
                .addPropertyValue("remark", "自定义的bdf")
                .setLazyInit(false)
                .getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("myDefineUser", userBeanDefinition);
        LOGGER.info("beanDefinitionCount is " + beanDefinitionRegistry.getBeanDefinitionCount());
    }

    /**
     * 可以获取到所有的bean definition 但bean尚未实例化
     * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor
     * @param configurableListableBeanFactory bean factory
     * @throws BeansException bean异常
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //configurableListableBeanFactory.
    }
}
