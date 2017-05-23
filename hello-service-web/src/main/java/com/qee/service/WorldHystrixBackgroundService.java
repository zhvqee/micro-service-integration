package com.qee.service;

import com.qee.remote.api.WorldServiceRemoteApi;
import com.qee.service.hystrix.impl.WorldServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzzhuqi1 on 2017/5/23.
 */
@FeignClient(value = "hello-service-compose" ,  fallback= WorldServiceFallBack.class)
public interface WorldHystrixBackgroundService extends WorldServiceRemoteApi {

     class HystrixClientFallback implements WorldHystrixBackgroundService {

        @Override
        public String worldHystrix(@RequestParam("name") String name) {
            return "error";
        }
    }
}
