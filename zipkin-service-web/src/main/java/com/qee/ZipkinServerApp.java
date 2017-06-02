package com.qee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApp {


    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApp.class, args);
    }
}
