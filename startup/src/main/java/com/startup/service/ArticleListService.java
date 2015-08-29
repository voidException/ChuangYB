package com.startup.service;

import com.startup.pojo.Article;

import java.util.List;
import java.util.Map;
public interface ArticleListService {//这里实现获取每次获取10个文章列表的功能
	public static final int  ARTICLE_ERROR=0;
	
	//根据给定的文章标签 页数和每次给出的长度，获取列表；注意所有的文章分类都映射成数字
	public List<Article> getListArticles (Map<String,Integer> map);
	
}
