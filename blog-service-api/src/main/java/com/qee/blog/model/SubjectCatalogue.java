package com.qee.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhuqi on 2018/12/29.
 * 主题目录
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCatalogue implements Serializable {

    /**
     * 主题Id
     */
    private String id;

    /**
     * 主题名
     */
    private String name;

    /**
     * 主题链接
     */
    private String link;

    /**
     * 样式
     */
    private String style;

}
