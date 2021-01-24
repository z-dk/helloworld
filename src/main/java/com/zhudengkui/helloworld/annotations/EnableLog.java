package com.zhudengkui.helloworld.annotations;

import com.zhudengkui.helloworld.filter.LogFilter;
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
