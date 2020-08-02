package com.zhudengkui.helloworld;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhudengkui.helloworld.**.mapper")
public class HellowordApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }
    
}
