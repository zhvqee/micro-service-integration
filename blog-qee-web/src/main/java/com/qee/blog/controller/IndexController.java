package com.qee.blog.controller;

import com.qee.blog.model.Article;
import com.qee.blog.model.Theme;
import com.qee.blog.service.ArticleService;
import com.qee.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuqi on 2018/12/28.
 */
@Controller
@RequestMapping("/blog/index")
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ThemeService themeService;


    @RequestMapping("/getAllArticles")
    @ResponseBody
    public Map<String, Object> receive() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Article> allArticle = articleService.getAllArticles();
        result.put("data", allArticle);
        return result;
    }

    @RequestMapping("/getThemeInfo")
    @ResponseBody
    public Map<String, Object> getThemeInfo() {
        Map<String, Object> result = new HashMap<String, Object>();
        Theme theme = themeService.getTheme();
        result.put("data", theme);
        return result;
    }

    @RequestMapping("/getArticleDetail")
    @ResponseBody
    public Map<String, Object> getArticleDetail(@RequestBody Article article) {
        Map<String, Object> result = new HashMap<String, Object>();
        Article detail = articleService.getArticleDetail(article.getArticleId());
        result.put("data", detail);
        return result;
    }
}
