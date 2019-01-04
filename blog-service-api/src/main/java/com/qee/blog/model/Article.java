package com.qee.blog.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by zhuqi on 2018/12/28.
 * 文章
 */
@Data
@ToString
public class Article implements Serializable {
    private static final long serialVersionUID = 8322073009981753993L;

    /**
     * 文章的Id
     */
    private Integer articleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 访问量
     */
    private Integer visitCount;

    /**
     * 标签
     */
    private List<String> tags;
}
