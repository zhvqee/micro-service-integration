package com.qee.remote.api.impl;

import com.qee.remote.api.WorldServiceRemoteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RestController
public class WorldServiceRemoteApiImpl implements WorldServiceRemoteApi {

    @Autowired
    private DiscoveryClient client;

    @Override
    public String worldHystrix(@RequestParam("name") String name) {
        ServiceInstance serviceInstance =client.getLocalServiceInstance();
       /* try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        String msg=serviceInstance.getHost()+":"+serviceInstance.getPort()+"   "+serviceInstance.getServiceId()+"  "+serviceInstance.getMetadata();
        return msg+"=="+name;
    }
}
