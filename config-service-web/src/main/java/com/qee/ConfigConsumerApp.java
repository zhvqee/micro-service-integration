package com.qee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigConsumerApp.class, args);
    }
}
