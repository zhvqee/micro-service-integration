package com.qee.service.hystrix.impl;

import com.qee.service.WorldHystrixBackgroundService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzzhuqi1 on 2017/5/23.
 */
@Component
public class WorldServiceFallBack implements WorldHystrixBackgroundService {


    @Override
    public String worldHystrix(@RequestParam("name") String name) {
        return "error";
    }
}
