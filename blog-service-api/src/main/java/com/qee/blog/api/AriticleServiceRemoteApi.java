package com.qee.blog.api;

import com.qee.blog.model.Article;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zhuqi on 2018/12/31.
 */
@RequestMapping("/article-service-api")
public interface AriticleServiceRemoteApi {
    /**
     * 获取所有的文章
     *
     * @return
     */
    @RequestMapping(value = "/getAllArticles", method = RequestMethod.GET)
    List<Article> getAllArticles();

    /**
     * 通过主题id 获取文章
     *
     * @return
     */
    @RequestMapping(value = "/getArticleBySubjectId", method = RequestMethod.GET)
    List<Article> getArticleBySubjectId(String subjectId);


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getArticleDetail", method = RequestMethod.POST)
    Article getArticleDetail(Integer articleId);

    /**
     * 编辑文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/getArticleDetail", method = RequestMethod.POST)
    int addOrEditArticle(Article article);

}
