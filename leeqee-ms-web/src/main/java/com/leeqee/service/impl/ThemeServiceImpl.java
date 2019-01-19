package com.leeqee.service.impl;

import com.leeqee.service.ThemeService;
import com.leeqee.service.remote.ThemeRemoteService;
import com.qee.blog.model.Theme;
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
