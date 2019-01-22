package com.qee.controller;

import com.qee.blog.api.AriticleServiceRemoteApi;
import com.qee.blog.model.Article;
import com.qee.mybatis.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuqi on 2019/1/22.
 */
@Controller
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private AriticleServiceRemoteApi ariticleServiceRemoteApi;

    @RequestMapping("/index")
    @ResponseBody
    public String index() throws SQLException {
        List<Article> allArticle = articleMapper.getAllArticles();
        Article article = new Article();
        article.setTitle("1");
        article.setContent("1");
        article.setIntroduce("1");
        article.setTags(Arrays.asList("2"));
        ariticleServiceRemoteApi.addOrEditArticle(article);
        Article articleDetail = ariticleServiceRemoteApi.getArticleDetail(1L);
        articleDetail.setIntroduce("xxx");
        ariticleServiceRemoteApi.addOrEditArticle(articleDetail);
        System.out.println(allArticle);
        return "hello spring boot";
    }
}
