package com.zhudengkui.helloworld;

import com.zhudengkui.helloworld.annotations.EnableLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author z_dk
 */
@SpringBootApplication
@MapperScan("com.zhudengkui.helloworld.**.mapper")
@EnableLog
@EnableAsync
public class HelloworldApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
    
}
