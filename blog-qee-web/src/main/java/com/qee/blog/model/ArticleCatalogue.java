package com.qee.blog.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhuqi on 2018/12/31.
 */
@Data
@ToString
public class ArticleCatalogue implements Serializable {
    private static final long serialVersionUID = 5506063505752962222L;

    /**
     * 文章id
     */
    private Integer articleId;

    private String articleTitle;


    private Integer style;
}
