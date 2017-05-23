package com.qee.remote.api;

import org.springframework.web.bind.annotation.*;


/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RequestMapping("/world-service-remote")
public interface WorldServiceRemoteApi {

    @RequestMapping(value = "/worldHystrix", method = RequestMethod.GET)
    String worldHystrix(@RequestParam("name") String name);


}
