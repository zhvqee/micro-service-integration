package com.qee.blog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhuqi on 2018/12/28.
 */
@Configuration
public class WebResourceConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/css/*").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/static/js/*").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/static/images/*").addResourceLocations("classpath:/static/images/");

        registry.addResourceHandler("/dll*").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }


}
