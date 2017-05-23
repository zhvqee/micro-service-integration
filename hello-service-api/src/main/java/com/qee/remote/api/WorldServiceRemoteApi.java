package com.qee.remote.api;

import org.springframework.web.bind.annotation.*;


/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
public interface WorldServiceRemoteApi {
    /**
     * 当需要进行降级服务的时候，则/world-service-remote不能配置在顶头，否则当jar引入到client时，
     * 回报 java.lang.IllegalStateException: Ambiguous mapping.
     * @param name
     * @return
     */
    @RequestMapping(value = "/world-service-remote/worldHystrix", method = RequestMethod.GET)
    String worldHystrix(@RequestParam("name") String name);


}
