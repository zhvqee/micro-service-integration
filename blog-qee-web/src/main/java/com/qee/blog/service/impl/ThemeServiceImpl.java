package com.qee.blog.service.impl;

import com.qee.blog.api.ThemeServiceRemoteApi;
import com.qee.blog.model.Theme;
import com.qee.blog.service.ThemeService;
import com.qee.blog.service.remote.ThemeRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhuqi on 2018/12/29.
 */
@Service
public class ThemeServiceImpl implements ThemeService {

    @Resource
    private ThemeRemoteService themeRemoteService;

    @Override
    public Theme getTheme() {
        return themeRemoteService.getTheme();
    }

}
