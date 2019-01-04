package com.qee.blog;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhuqi on 2018/12/28.
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class BlogApp {

    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class, args);
    }
}
