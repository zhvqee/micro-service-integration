package com.qee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * Created by hzzhuqi1 on 2017/6/2.
 */

@EnableZuulProxy
@SpringBootApplication
@SpringCloudApplication
public class ZuulDynamicGateWayApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulDynamicGateWayApp.class, args);
    }

   /* @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }*/

}
