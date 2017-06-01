package com.qee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServerApp {


    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApp.class, args);
    }
}
