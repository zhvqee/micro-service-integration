package com.qee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineServiceApp {


    public static void main(String[] args) {
        SpringApplication.run(TurbineServiceApp.class, args);
    }
}
