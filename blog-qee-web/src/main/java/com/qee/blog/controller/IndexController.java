package com.qee.blog.controller;

import com.qee.blog.model.Article;
import com.qee.blog.model.Theme;
import com.qee.blog.service.ArticleService;
import com.qee.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuqi on 2018/12/28.
 */
@RestController
@RequestMapping("/blog/index")
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ThemeService themeService;


    @RequestMapping("/getAllArticles")
    @ResponseBody
    public Map<String, Object> receive() {
        Map<String, Object> result = new HashMap<>();
        List<Article> allArticle = articleService.getAllArticle();
        result.put("data", allArticle);
        return result;
    }

    @RequestMapping("/getThemeInfo")
    @ResponseBody
    public Map<String, Object> index() {
        Map<String, Object> result = new HashMap<>();
        Theme theme = themeService.getTheme();
        result.put("data", theme);
        return result;
    }
}
