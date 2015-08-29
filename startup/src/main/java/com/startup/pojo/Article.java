package com.startup.pojo;

import java.util.Date;

public class Article {
    private Integer articleid;

    private String title;

    private String vicetitle;

    private String miniphotourl;

    private String realurl;

    private String content;

    private Integer articletype;

    private Integer labelzero;

    private Integer labelone;

    private Integer labeltwo;

    private Integer labelthree;

    private Integer labelfour;

    private Integer labelfive;

    private Integer labelsix;

    private Integer comments;

    private Integer love;

    private Integer collect;

    private Date publishtime;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getVicetitle() {
        return vicetitle;
    }

    public void setVicetitle(String vicetitle) {
        this.vicetitle = vicetitle == null ? null : vicetitle.trim();
    }

    public String getMiniphotourl() {
        return miniphotourl;
    }

    public void setMiniphotourl(String miniphotourl) {
        this.miniphotourl = miniphotourl == null ? null : miniphotourl.trim();
    }

    public String getRealurl() {
        return realurl;
    }

    public void setRealurl(String realurl) {
        this.realurl = realurl == null ? null : realurl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getArticletype() {
        return articletype;
    }

    public void setArticletype(Integer articletype) {
        this.articletype = articletype;
    }

    public Integer getLabelzero() {
        return labelzero;
    }

    public void setLabelzero(Integer labelzero) {
        this.labelzero = labelzero;
    }

    public Integer getLabelone() {
        return labelone;
    }

    public void setLabelone(Integer labelone) {
        this.labelone = labelone;
    }

    public Integer getLabeltwo() {
        return labeltwo;
    }

    public void setLabeltwo(Integer labeltwo) {
        this.labeltwo = labeltwo;
    }

    public Integer getLabelthree() {
        return labelthree;
    }

    public void setLabelthree(Integer labelthree) {
        this.labelthree = labelthree;
    }

    public Integer getLabelfour() {
        return labelfour;
    }

    public void setLabelfour(Integer labelfour) {
        this.labelfour = labelfour;
    }

    public Integer getLabelfive() {
        return labelfive;
    }

    public void setLabelfive(Integer labelfive) {
        this.labelfive = labelfive;
    }

    public Integer getLabelsix() {
        return labelsix;
    }

    public void setLabelsix(Integer labelsix) {
        this.labelsix = labelsix;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}