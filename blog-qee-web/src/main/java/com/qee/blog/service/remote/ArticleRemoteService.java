package com.qee.blog.service.remote;

import com.qee.blog.api.AriticleServiceRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by zhuqi on 2018/12/31.
 */
@FeignClient("blog-service-compose")
public interface ArticleRemoteService extends AriticleServiceRemoteApi {
}
