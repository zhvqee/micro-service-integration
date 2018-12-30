package com.qee.blog.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhuqi on 2018/12/29.
 * 主题
 */
@Data
@ToString
public class Theme implements Serializable {

    /**
     * 主标题栏
     */
    private List<SubjectCatalogue> topSubjectCatalogueList;

    private List<SubjectCatalogue> rightSubjectCatalogueList;

}
