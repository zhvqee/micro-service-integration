package com.qee.service;

import com.qee.remote.api.HelloServiceRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@FeignClient(value = "hello-service-compose")
public interface HelloBackgroundService extends HelloServiceRemoteApi{
}
