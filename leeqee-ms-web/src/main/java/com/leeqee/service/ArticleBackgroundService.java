package com.leeqee.service;

import com.qee.blog.model.Article;

import java.util.List;

/**
 * Created by zhuqi on 2018/12/28.
 */
public interface ArticleBackgroundService {

    /**
     * 获取所有的文章
     *
     * @return
     */
    List<Article> getAllArticles();
    /**
     * 更新文章
     * @param article
     * @return
     */
    int addOrUpdateArticle(Article article);
}
