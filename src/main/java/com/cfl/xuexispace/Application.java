package com.cfl.xuexispace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.cfl.xuexispace.mapper"})
@ComponentScan(basePackages = {"com.cfl.xuexispace.controller","com.cfl.xuexispace.service","com.cfl.xuexispace.interceptor"})
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
