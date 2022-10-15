package com.zdk.hello.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

/**
 * @author zdk
 */
public class HelloWorldSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    /**
     * 触发点发生在postProcessBeforeInstantiation之前
     * 这个方法用于预测Bean的类型，返回第一个预测成功的Class类型，如果不能预测返回null；
     * 当调用BeanFactory.getType(name)时当通过bean的名字无法得到bean类型信息时就调用该回调方法来决定类型信息。
     * @param beanClass 原始bean类
     * @param beanName bean名称
     * @return bean最终的类，如不可预测返回null
     * @throws BeansException bean异常
     */
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    /**
     * 触发点发生在postProcessBeforeInstantiation之后，用于确定该bean的构造函数之用，返回的是该bean的所有构造函数列表。
     * 用户可以扩展这个点，来自定义选择相应的构造器来实例化这个bean。
     * @param beanClass bean类
     * @param beanName bean名称
     * @return 用于实例化该bean的构造函数，不指定构造函数时返回null
     * @throws BeansException bean异常
     */
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return new Constructor[0];
    }

    /**
     * 触发点发生在postProcessAfterInstantiation之后，当有循环依赖的场景，当bean实例化好之后，为了防止有循环依赖，会提前暴露回调方法，
     * 用于bean实例化的后置处理。这个方法就是在提前暴露的回调方法中触发。
     * @param bean bean对象
     * @param beanName bean名称
     * @return 暴漏出的bean对象引用
     * @throws BeansException bean异常
     */
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
