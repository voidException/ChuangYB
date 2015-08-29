package com.startup.vo;
import java.util.List;

import com.startup.pojo.Article;
public class ArticleVo extends BaseVo {
	private List<Article> article;
	
	public void setArticle(List<Article> article){
		this.article=article;
	}
	
	public List<Article> getArticle(){
		return article;
	}

}
