package com.qee.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuqi on 2018/12/28.
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class BlogApp {



    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class, args);
    }
}
