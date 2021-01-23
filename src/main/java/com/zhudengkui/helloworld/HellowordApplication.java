package com.zhudengkui.helloworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author z_dk
 */
@SpringBootApplication
@MapperScan("com.zhudengkui.helloworld.**.mapper")
public class HellowordApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }
    
}
