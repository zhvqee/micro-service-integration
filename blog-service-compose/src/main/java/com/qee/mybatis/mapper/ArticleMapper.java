package com.qee.mybatis.mapper;

import com.qee.blog.model.Article;

import java.util.List;

/**
 * Created by zhuqi on 2019/1/22.
 */
public interface ArticleMapper {

    List<Article> getAllArticles();

    Article getArticleById(Long id);

    int insertArticle(Article article);

    int updateArticle(Article article);


}
