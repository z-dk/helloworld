package com.zhudengkui.helloworld;

import com.zhudengkui.helloworld.annotations.EnableLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author z_dk
 */
@SpringBootApplication
@MapperScan("com.zhudengkui.helloworld.**.mapper")
@EnableLog
public class HellowordApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }
    
}
