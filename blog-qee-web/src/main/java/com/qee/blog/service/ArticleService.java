package com.qee.blog.service;

import com.qee.blog.model.Article;

import java.util.List;

/**
 * Created by zhuqi on 2018/12/28.
 */
public interface ArticleService {

    /**
     * 获取所有的文章
     *
     * @return
     */
    List<Article> getAllArticles();

    /**
     * 通过主题id 获取文章
     *
     * @return
     */
    List<Article> getArticleBySubjectId(String subjectId);


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    Article getArticleDetail(Long articleId);
}
