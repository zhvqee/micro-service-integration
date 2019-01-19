package com.leeqee.service.impl;

import com.leeqee.service.ArticleBackgroundService;
import com.leeqee.service.remote.ArticleRemoteService;
import com.qee.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuqi on 2018/12/28.
 */
@Service
public class ArticleBackgroundServiceImpl implements ArticleBackgroundService {


    @Autowired
    private ArticleRemoteService ariticleRemoteService;

    @Override
    public List<Article> getAllArticles() {
        return ariticleRemoteService.getAllArticles();
    }

    @Override
    public int addOrUpdateArticle(Article article) {
        return ariticleRemoteService.addOrEditArticle(article);
    }

}
