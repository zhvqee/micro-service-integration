package com.qee.remote.service;

import com.qee.blog.api.AriticleServiceRemoteApi;
import com.qee.blog.model.Article;
import com.qee.mybatis.mapper.ArticleMapper;
import com.qee.util.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhuqi on 2018/12/31.
 */
@RestController
public class AriticleServiceRemoteApiImpl implements AriticleServiceRemoteApi {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticles() {
        List<Article> result = new ArrayList<Article>();
        List<Article> allArticles = articleMapper.getAllArticles();
        if(CollectionUtils.isEmpty(allArticles)){
            return result;
        }
        for(Article article: allArticles){
            List<String> tagsList = FastJsonUtil.parseList(article.getTagsStr(), String.class);
            article.setTags(tagsList);
        }
        return allArticles;
    }

    @Override
    public List<Article> getArticleBySubjectId(String subjectId) {
        List<Article> allArticles = getAllArticles();
        if("djl".equals(subjectId)){
            Collections.sort(allArticles, new Comparator<Article>() {
                @Override
                public int compare(Article o1, Article o2) {
                    return o2.getVisitCount().compareTo(o1.getVisitCount());
                }
            });
            return new ArrayList<>(allArticles.subList(0,Math.min(10,allArticles.size())));
        }else if("phb".equals(subjectId)){
            Collections.sort(allArticles, new Comparator<Article>() {
                @Override
                public int compare(Article o1, Article o2) {
                    return o2.getUpdateTime().compareTo(o2.getUpdateTime());
                }
            });
            return new ArrayList<>(allArticles.subList(0,Math.min(10,allArticles.size())));
        }
        return new ArrayList<>(allArticles.subList(0,Math.min(10,allArticles.size())));
    }

    @Override
    public Article getArticleDetail(Long articleId) {
       return articleMapper.getArticleById(articleId);
    }

    @Override
    public int addOrEditArticle(Article article) {
        article.setTagsStr(FastJsonUtil.toJSONString(article.getTags()));
        if(article.getArticleId()==null){
            articleMapper.insertArticle(article);
        }
        return articleMapper.updateArticle(article);
    }

}
