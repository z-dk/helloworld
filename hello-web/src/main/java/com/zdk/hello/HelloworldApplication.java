package com.zdk.hello;

import com.zdk.hello.annotations.EnableLog;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @see ApplicationContextAware ：用来获取ApplicationContext的一个扩展类，ApplicationContext应该是很多人非常熟悉的一个类了，<br/>
 *     就是spring上下文管理器，可以手动的获取任何在spring上下文注册的bean，我们经常扩展这个接口来缓存spring上下文，包装成静态方法。<br/>
 *     同时ApplicationContext也实现了BeanFactory，MessageSource，ApplicationEventPublisher等接口，也可以用来做相关接口的事情。<br/>
 * @see BeanFactoryAware :这个类只有一个触发点，发生在bean的实例化之后，注入属性之前，也就是Setter之前。
 * 这个类的扩展点方法为setBeanFactory，可以拿到BeanFactory这个属性。
 * 使用场景为，
 * 1、可以在bean实例化之后，但还未初始化之前，拿到 BeanFactory，在这个时候，可以对每个bean作特殊化的定制。
 * 2、可以把BeanFactory拿到进行缓存，之后使用。
 * @author zdk
 */
@SpringBootApplication
@EnableLog
@EnableAsync
@MapperScan(basePackages = "com.zdk.hello.mapper.zdkdata", sqlSessionFactoryRef = "zdkSqlSessionFactory")
@MapperScan(basePackages = "com.zdk.hello.mapper.helloworld", sqlSessionFactoryRef = "helloWorldSqlSessionFactory")
public class HelloworldApplication implements CommandLineRunner, BeanFactoryAware, ApplicationContextAware {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloworldApplication.class);
    
    private static BeanFactory beanFactory;
    
    private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
        LOGGER.info("================== run finished ==================");
        if (applicationContext instanceof ConfigurableApplicationContext) {
            ((ConfigurableApplicationContext) applicationContext).close();
        }
    }

    /**
     * 整个项目启动完毕后(started Application 之后但仍在run方法内部)，自动执行
     * 使用场景：扩展此接口，进行启动项目之后一些业务的预处理。
     * @param args 参数
     * @throws Exception 异常
     */
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("application is started, I'm CommandLineRunner");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        HelloworldApplication.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        HelloworldApplication.applicationContext = applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
