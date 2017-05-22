package com.qee.controller;

import com.qee.remote.api.impl.HelloServiceRemoteApi;
import com.qee.remote.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RestController
public class Hello2Controller {

    @Autowired
    private HelloServiceRemoteApi helloServiceRemoteApi;

    @RequestMapping("/hello2")
    public Map<String,Object> hello(){
        Map<String,Object> ret = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        String s1 = helloServiceRemoteApi.hello("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = helloServiceRemoteApi.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = helloServiceRemoteApi.hello(new User("王五", 19));
        sb.append(s3).append("\n");
        ret.put("show",sb.toString());
        return ret;
    }
}
