package com.qee.blog.service.impl;

import com.qee.blog.model.Article;
import com.qee.blog.service.ArticleService;
import com.qee.blog.service.remote.ArticleRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuqi on 2018/12/28.
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleRemoteService ariticleRemoteService;

    @Override
    public List<Article> getAllArticles() {
        return ariticleRemoteService.getAllArticles();
    }

    @Override
    public List<Article> getArticleBySubjectId(String subjectId) {
        return ariticleRemoteService.getArticleBySubjectId(subjectId);
    }

    @Override
    public Article getArticleDetail(Integer articleId) {
        return ariticleRemoteService.getArticleDetail(articleId);

    }
}
