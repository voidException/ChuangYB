package com.startup.vo;
/* 
 * 这个是用来请求
 * 具体一篇文章的，需要传输文章的唯一主键;
 * 也可以用来请求一篇文章的评论
 * @author  aihaitao
 */
public class ArticlePostVo extends CommonVo {
	  private Integer articleiD;//请求被传输的文章的iD主键

	public Integer getArticleiD() {
		return articleiD;
	}

	public void setArticleiD(Integer articleiD) {
		this.articleiD = articleiD;
	}
	  
}
