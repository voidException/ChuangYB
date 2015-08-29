package com.startup.service;

import com.startup.pojo.Article;

public interface ArticleService {	
	
	public Article getArticle(int articleid);
	
	public int addLove(int  articleid);
	
	public int getCommentsNum(int articleid);
	
	public int IfArticleIdExist(int articleId);

	public int deleteLove(int articleId);
	
}
