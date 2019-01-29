package com.qee.blog.api;

import com.qee.blog.model.Article;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    List<Article> getArticleBySubjectId(@RequestParam(name = "subjectId") String subjectId);


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getArticleDetail", method = RequestMethod.POST)
    Article getArticleDetail(@RequestParam(name = "articleId") Long articleId);

    /**
     * 编辑文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/addOrEditArticle", method = RequestMethod.POST)
    int addOrEditArticle(@RequestBody Article article);

}
