package com.framework.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class Application  {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
