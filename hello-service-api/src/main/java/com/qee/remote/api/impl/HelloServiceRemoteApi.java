package com.qee.remote.api.impl;
import com.qee.remote.model.User;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RequestMapping("/hello-test-web")
public interface HelloServiceRemoteApi {

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);


    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);


}
