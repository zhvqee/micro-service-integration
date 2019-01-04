package com.qee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuqi on 2018/12/28.
 */
@Controller
@RequestMapping("/blog/index")
public class IndexController {


    @RequestMapping("/cc")
    public String index() {
        return "index";
    }

}
