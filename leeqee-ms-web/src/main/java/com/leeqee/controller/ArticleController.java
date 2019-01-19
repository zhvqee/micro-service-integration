package com.leeqee.controller;

import com.leeqee.service.ArticleBackgroundService;
import com.qee.blog.model.Article;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuqi on 2019/1/17.
 */
@RestController
@RequestMapping("/blog/index")
public class ArticleController {

    @Resource
    private ArticleBackgroundService articleService;


    @RequestMapping("/getAllArticleList")
    public Map<String,Object> getArticleList(){
        Map<String,Object> map =  new HashMap<>();
        List<Article> allArticles = articleService.getAllArticles();
        map.put("data",allArticles);
        return map;
    }

    @RequestMapping("/addOrUpdateArticle")
    public Map<String,Object> addOrUpdateArticle(@RequestBody Article article){
        Map<String,Object> map =  new HashMap<>();
        int ret = articleService.addOrUpdateArticle(article);
        map.put("data",ret);
        return map;
    }
}
