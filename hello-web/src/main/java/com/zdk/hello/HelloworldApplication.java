package com.zdk.hello;

import com.zdk.hello.annotations.EnableLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author z_dk
 */
@SpringBootApplication
@MapperScan("com.**.mapper")
@EnableLog
@EnableAsync
public class HelloworldApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
    
}
