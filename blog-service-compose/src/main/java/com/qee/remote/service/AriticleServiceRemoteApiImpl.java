package com.qee.remote.service;

import com.qee.blog.api.AriticleServiceRemoteApi;
import com.qee.blog.model.Article;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by zhuqi on 2018/12/31.
 */
@RestController
public class AriticleServiceRemoteApiImpl implements AriticleServiceRemoteApi {
    @Override
    public List<Article> getAllArticles() {
        List<Article> result = new ArrayList<Article>();
        for (int i = 1; i <= 2; i++) {
            Article article = new Article();
            article.setArticleId(i);
            article.setTitle("标题" + i);
            article.setContent(getContent());
            article.setAuthor("bird");
            article.setTags(Arrays.asList("java", "分布式"));
            article.setCreateTime(new Timestamp(System.currentTimeMillis()));
            article.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            article.setVisitCount(new Random().nextInt(5000));
            result.add(article);
        }
        return result;
    }

    @Override
    public List<Article> getArticleBySubjectId(String subjectId) {
        return null;
    }

    @Override
    public Article getArticleDetail(Integer articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        article.setTitle("文章内容");
        article.setCreateTime(new Timestamp(System.currentTimeMillis()));
        article.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        article.setContent("11111111");
        article.setAuthor("bird");
        article.setVisitCount(1000);
        article.setTags(Arrays.asList("java"));
        return article;
    }

    @Override
    public int addOrEditArticle(Article article) {
        return 0;
    }

    String getContent() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        int nextInt = random.nextInt(2);
        for (int i = 0; i < nextInt; i++) {
            builder.append("这是文章内容");
        }
        return builder.toString();
    }
}
