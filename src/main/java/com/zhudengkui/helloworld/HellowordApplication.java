package com.zhudengkui.helloworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zhudengkui.helloworld")
@MapperScan("com.zhudengkui.helloworld.user.mapper")
public class HellowordApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }
    
}
