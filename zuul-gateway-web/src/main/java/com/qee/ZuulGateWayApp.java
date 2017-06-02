package com.qee;

import com.qee.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by hzzhuqi1 on 2017/6/2.
 */

@EnableZuulProxy
@SpringBootApplication
@SpringCloudApplication
public class ZuulGateWayApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApp.class, args);
    }

}
