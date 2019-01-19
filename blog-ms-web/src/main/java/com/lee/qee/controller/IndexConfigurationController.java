package com.lee.qee.controller;

import com.qee.blog.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhuqi on 2019/1/17.
 */
@Controller
@RequestMapping("/blog/index")
public class IndexConfigurationController {

    @RequestMapping("/getAllArticleList")
    public Map<String,Object> getArticleList(){
        Map<String,Object> map =  new HashMap<>();
        List<Article> result = new ArrayList<Article>();
        for (int i = 1; i <= 2; i++) {
            Article article = new Article();
            article.setArticleId(i);
            article.setTitle("标题" + i);
            article.setContent("xxxxxxx");
            article.setAuthor("bird");
            article.setTags(Arrays.asList("java", "分布式"));
            article.setCreateTime(new Timestamp(System.currentTimeMillis()));
            article.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            article.setVisitCount(new Random().nextInt(5000));
            result.add(article);
        }
        map.put("data",result);
        return map;
    }
}
