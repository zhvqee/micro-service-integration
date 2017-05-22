package com.qee.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloProviderApplication.class, args);
    }
}
