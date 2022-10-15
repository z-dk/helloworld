package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @see BeanNameAware bean的初始化之前，也就是postProcessBeforeInitialization之前执行
 * @see InitializingBean 为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，凡是继承该接口的类，
 *      在初始化bean的时候都会执行该方法。这个扩展点的触发时机在postProcessAfterInitialization之前。
 *      使用场景：用户实现此接口，来进行系统启动的时候一些业务指标的初始化工作。
 * @author zdk
 */
@Component
public class HelloWorldBeanNameInitializingAware implements BeanNameAware, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldBeanNameInitializingAware.class);

    @Override
    public void setBeanName(String name) {
        // 调用这个方法可修改bean名称
        LOGGER.info("My name is {}", name);
    }

    /**
     * 在bean的初始化阶段，如果对一个方法标注了@PostConstruct，会先调用这个方法。
     * 这里重点是要关注下这个标准的触发点，这个触发点是在
     * @see InstantiationAwareBeanPostProcessor#postProcessBeforeInitialization 之后，
     * @see InitializingBean#afterPropertiesSet 之前。
     * 使用场景：用户可以对某一方法进行标注，来进行初始化某一个属性
     */
    @PostConstruct
    public void init() {
        setBeanName("hello-world");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
