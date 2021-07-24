package com.zdk.hello.annotations;

import java.lang.annotation.*;

/**
 * @author zdk
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    
    String name() default TargetDataSource.HELLO_WORLD;
    
    String HELLO_WORLD = "hello-world";
    
    String ZDK_DATA = "zdk-data";
    
}
