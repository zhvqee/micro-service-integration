package com.qee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApp {


    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp.class, args);
    }
}
