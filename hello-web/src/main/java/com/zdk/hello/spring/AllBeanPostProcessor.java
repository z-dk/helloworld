package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zdk
 */
@Component
public class AllBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AllBeanPostProcessor.class);

    /**
     * 实例化bean之前，相当于new这个bean之前
     * @param beanClass bean类
     * @param beanName bean名称
     * @return bean实现，如果为null则使用默认实现
     * @throws BeansException bean异常
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        LOGGER.info("bean[{}] postProcessBeforeInstantiation...", beanName);
        return null;
    }

    /**
     * 实例化bean之后，相当于new这个bean之后
     * @param bean bean类
     * @param beanName bean名称
     * @return 是否执行后续的属性填充processor
     * @throws BeansException bean异常
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        LOGGER.info("bean[{}] postProcessAfterInstantiation...", beanName);
        return true;
    }

    /**
     * bean已经实例化完成，在属性注入时阶段触发，@Autowired,@Resource等注解原理基于此方法实现
     * @param pvs 属性值
     * @param bean bean对象
     * @param beanName bean名称
     * @return bean实际应用的属性值
     * @throws BeansException bean异常
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        LOGGER.info("bean[{}] postProcessProperties...", beanName);
        return null;
    }

    /**
     * 初始化bean之前，即把bean注入spring上下文之前
     * @param bean bean对象
     * @param beanName bean名称
     * @return bean实例对象，如果为null则不会再执行后续的后置处理(init-param,@postConstruct)
     * @throws BeansException bean异常
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("bean[{}] postProcessBeforeInitialization...", beanName);
        //return !Objects.equals(beanName, "springBeanLifeCycle") ? bean : null;
        return bean;
    }

    /**
     * 初始化bean之后，即把bean注入spring上下文之后
     * @param bean bean对象
     * @param beanName bean名称
     * @return bean实例对象，如果为null则不会再执行后续的后置处理(待确认后续还有哪些)
     * @throws BeansException bean异常
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("bean[{}] postProcessAfterInitialization...", beanName);
        //return !Objects.equals(beanName, "springBeanLifeCycle") ? bean : null;
        return bean;
    }
}
