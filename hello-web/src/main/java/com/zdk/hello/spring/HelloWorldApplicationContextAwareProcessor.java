package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import java.util.Locale;

/**
 * ApplicationContextAwareProcessor 该类存在6个扩展点<br/>
 * @see EnvironmentAware:用于获取EnvironmentAware的一个扩展类，这个变量非常有用， 可以获得系统内的所有参数。当然个人认为这个Aware没必要去扩展，<br/>
 *     因为spring内部都可以通过注入的方式来直接获得。<br/>
 * @see EmbeddedValueResolverAware ：用于获取StringValueResolver的一个扩展类， StringValueResolver用于获取基于String类型<br/>
 *     的properties的变量，一般我们都用@Value的方式去获取，如果实现了这个Aware接口，把StringValueResolver缓存起来，<br/>
 *     通过这个类去获取String类型的变量，效果是一样的。<br/>
 * @see ResourceLoaderAware ：用于获取ResourceLoader的一个扩展类，ResourceLoader可以用于获取classpath内所有的资源对象，<br/>
 *     可以扩展此类来拿到ResourceLoader对象。<br/>
 * @see ApplicationEventPublisherAware ：用于获取ApplicationEventPublisher的一个扩展类，ApplicationEventPublisher可以用来发布事件，<br/>
 *     结合ApplicationListener来共同使用，下文在介绍ApplicationListener时会详细提到。这个对象也可以通过spring注入的方式来获得。<br/>
 * @see MessageSourceAware ：用于获取MessageSource的一个扩展类，MessageSource主要用来做国际化。<br/>
 * @see ApplicationContextAware ：用来获取ApplicationContext的一个扩展类，ApplicationContext应该是很多人非常熟悉的一个类了，<br/>
 *     就是spring上下文管理器，可以手动的获取任何在spring上下文注册的bean，我们经常扩展这个接口来缓存spring上下文，包装成静态方法。<br/>
 *     同时ApplicationContext也实现了BeanFactory，MessageSource，ApplicationEventPublisher等接口，也可以用来做相关接口的事情。<br/>
 * @author zdk
 */
public class HelloWorldApplicationContextAwareProcessor implements EnvironmentAware, EmbeddedValueResolverAware,
        ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplicationContextAwareProcessor.class);

    @Override
    public void setEnvironment(Environment environment) {
        // 获取环境数据，
        String[] activeProfiles = environment.getActiveProfiles();
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String port = resolver.resolveStringValue("server.port");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource = resourceLoader.getResource("classpath:application.yml");
        if (resource.exists()) {
            LOGGER.info("application.yml is exist");
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent(this) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        String hello = messageSource.getMessage("hello", new Object[]{0, 2}, Locale.getDefault());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String applicationName = applicationContext.getApplicationName();
    }

}
