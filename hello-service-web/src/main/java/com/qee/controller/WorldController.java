package com.qee.controller;

import com.qee.service.WorldHystrixBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RestController
public class WorldController {

    @Autowired
    @Qualifier("worldHystrixBackgroundService")
    private WorldHystrixBackgroundService worldHystrixBackgroundService;


    @RequestMapping("/worldHystrix")
    @ResponseBody
    public Map<String,Object> worldHystrix() {
        Map<String,Object> ret = new HashMap<String, Object>();
        String info = worldHystrixBackgroundService.worldHystrix("hello world");
        ret.put("info",info);
        return ret;
    }

}
