package com.qee.blog.api;

import com.qee.blog.model.Theme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhuqi on 2018/12/31.
 */
@RequestMapping("/theme-service-api")
public interface ThemeServiceRemoteApi {
    /**
     * 获取主题信息
     *
     * @return
     */
    @RequestMapping(value = "/getTheme", method = RequestMethod.GET)
    Theme getTheme();

    /**
     * 设置主题
     * @param theme
     * @return
     */
    @RequestMapping(value = "/setTheme", method = RequestMethod.GET)
    int setTheme(Theme theme);
}
