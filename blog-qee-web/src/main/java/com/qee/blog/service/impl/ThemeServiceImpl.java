package com.qee.blog.service.impl;

import com.qee.blog.model.SubjectCatalogue;
import com.qee.blog.model.Theme;
import com.qee.blog.service.ThemeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqi on 2018/12/29.
 */
@Service
public class ThemeServiceImpl implements ThemeService {
    @Override
    public Theme getTheme() {
        Theme theme = new Theme();
        List<SubjectCatalogue> topCatalogueList = new ArrayList<>();
        topCatalogueList.add(new SubjectCatalogue("left-1", "我的笔记", "/", null));
        topCatalogueList.add(new SubjectCatalogue("left-2", "生活录", "/error", null));
        theme.setTopSubjectCatalogueList(topCatalogueList);

        List<SubjectCatalogue> rightCatalogueList = new ArrayList<>();
        rightCatalogueList.add(new SubjectCatalogue("right-1", "关注我", "/", "gzwm"));
        rightCatalogueList.add(new SubjectCatalogue("right-2", "文章推荐", "/", null));
        rightCatalogueList.add(new SubjectCatalogue("right-2", "点击排行", "/", null));

        theme.setRightSubjectCatalogueList(rightCatalogueList);

        return theme;
    }
}
