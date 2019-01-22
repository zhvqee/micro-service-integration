package com.qee.remote.service;

import com.qee.blog.api.ThemeServiceRemoteApi;
import com.qee.blog.model.SubjectCatalogue;
import com.qee.blog.model.Theme;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqi on 2019/1/4.
 */
@RestController
public class ThemeServiceRemoteApiImpl implements ThemeServiceRemoteApi {


    @Override
    public Theme getTheme() {
        Theme theme = new Theme();
        List<SubjectCatalogue> topCatalogueList = new ArrayList<SubjectCatalogue>();
        topCatalogueList.add(new SubjectCatalogue("left-1", "我的笔记", "/", null));
        topCatalogueList.add(new SubjectCatalogue("left-2", "生活录", "/error", null));
        theme.setTopSubjectCatalogueList(topCatalogueList);

        List<SubjectCatalogue> rightCatalogueList = new ArrayList<SubjectCatalogue>();
        rightCatalogueList.add(new SubjectCatalogue("gzw", "关注我", "/", "gzwm"));
        rightCatalogueList.add(new SubjectCatalogue("phb", "文章推荐", "/", null));
        rightCatalogueList.add(new SubjectCatalogue("djl", "点击排行", "/", null));

        theme.setRightSubjectCatalogueList(rightCatalogueList);

        return theme;
    }

    @Override
    public int setTheme(Theme theme) {
        return 0;
    }
}
