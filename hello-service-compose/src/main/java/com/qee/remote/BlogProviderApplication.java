package com.qee.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class BlogProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProviderApplication.class, args);
    }
}
