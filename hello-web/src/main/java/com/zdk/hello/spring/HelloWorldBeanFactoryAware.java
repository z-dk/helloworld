package com.zdk.hello.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 这个类只有一个触发点，发生在bean的实例化之后，注入属性之前，也就是Setter之前。
 * 这个类的扩展点方法为setBeanFactory，可以拿到BeanFactory这个属性。
 *
 * 使用场景为，
 * 1、可以在bean实例化之后，但还未初始化之前，拿到 BeanFactory，在这个时候，可以对每个bean作特殊化的定制。
 * 2、可以把BeanFactory拿到进行缓存，之后使用。
 * @author zdk
 */
public class HelloWorldBeanFactoryAware implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
