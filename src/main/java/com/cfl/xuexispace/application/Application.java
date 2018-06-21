package com.cfl.xuexispace.application;

import com.cfl.xuexispace.MyInterceptor.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.cfl.xuexispace.mapper"})
@ComponentScan(basePackages = {"com.cfl.xuexispace.controller","com.cfl.xuexispace.service"})
public class Application extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
