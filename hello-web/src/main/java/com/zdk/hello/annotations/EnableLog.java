package com.zdk.hello.annotations;

import com.zdk.hello.filter.LogFilter;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author z_dk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogFilter.class)
public @interface EnableLog {
    
}
