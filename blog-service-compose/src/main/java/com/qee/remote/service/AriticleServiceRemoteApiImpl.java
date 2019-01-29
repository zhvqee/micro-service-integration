package com.qee.remote.service;

import com.qee.blog.api.AriticleServiceRemoteApi;
import com.qee.blog.model.Article;
import com.qee.mybatis.mapper.ArticleMapper;
import com.qee.util.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
            List<String> tagsList = FastJsonUtil.parseList(article.getTagsStr2(), String.class);
            article.setTags(tagsList);
        }
        return allArticles;
    }

    @Override
    public List<Article> getArticleBySubjectId(@RequestParam(name = "subjectId") String subjectId) {
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
    public Article getArticleDetail(@RequestParam(name = "articleId")Long articleId) {
        Article article = articleMapper.getArticleById(articleId);
        if(article==null){
            return null;
        }
        List<String> tagsList = FastJsonUtil.parseList(article.getTagsStr2(), String.class);
        String tagStr=article.getTagsStr();
        if(!CollectionUtils.isEmpty(tagsList)){
            for(String tag: tagsList){
                tagStr+=",";
                tagStr+=tag;
            }
        }
        article.setTagsStr(tagStr);
        return article;
    }

    @Override
    public int addOrEditArticle(@RequestBody  Article article) {
        article.setTagsStr2(FastJsonUtil.toJSONString(article.getTags()));
        if(StringUtils.isEmpty(article.getAuthor())){
            article.setAuthor("记录者");
        }
        if(article.getArticleId()==null){
            articleMapper.insertArticle(article);
        }
        return articleMapper.updateArticle(article);
    }

}
