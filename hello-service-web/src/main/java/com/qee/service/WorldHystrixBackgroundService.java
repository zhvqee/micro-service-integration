package com.qee.service;

import com.qee.remote.api.WorldServiceRemoteApi;
import com.qee.service.hystrix.impl.WorldServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by hzzhuqi1 on 2017/5/23.
 */
@FeignClient(value = "hello-service-compose" ,  fallback= WorldServiceFallBack.class)
public interface WorldHystrixBackgroundService extends WorldServiceRemoteApi {


}
