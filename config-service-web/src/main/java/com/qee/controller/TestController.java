package com.qee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzzhuqi1 on 2017/6/1.
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;


    @RequestMapping("/from")
    public String from(){
        return this.from;
    }

    @RequestMapping("/from2")
    public String from2(){
        return environment.getProperty("from","undefined");
    }
}
