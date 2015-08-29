package com.startup.service.impl;

import com.startup.dao.ArticleMapper;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.service.ArticleService;
import com.startup.util.GetPrivateAuth;
import com.startup.pojo.Article;

@Transactional
@Service("articleservice")
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleMapper articleMapper;
	
	@Override 
	//@Cacheable(value="accountCache")
	public Article getArticle(int articleId){
		Article article = articleMapper.selectByPrimaryKey(articleId);
		
		GetPrivateAuth getPrivateAuth = new GetPrivateAuth();
		String miniPhotoUrl = getPrivateAuth.privateDownloadUrl(article.getMiniphotourl());
		String realUrl = getPrivateAuth.privateDownloadUrl(article.getRealurl());
		
		article.setMiniphotourl(miniPhotoUrl);
		article.setRealurl(realUrl);
		return article;
	}
	
	@Override
	public int  getCommentsNum(int articleId){
		Article  article = articleMapper.selectByPrimaryKey(articleId);
		return article.getComments();	
	}

	@Override
	public int IfArticleIdExist(int articleId) {
		Article article = articleMapper.selectByPrimaryKey(articleId);
		if(article == null)
			return 0;
		else 
			return 1;
	}

	@Override
	public int addLove(int  articleid) {		
		Article  article=articleMapper.selectByPrimaryKey(articleid);
		int love = article.getLove();
		if(love >= 99999)
			love = 99999;
		else {
			love++;
			article.setLove(love);
			articleMapper.updateByPrimaryKey(article);
		}
		return love;
	}
	
	@Override
	public int deleteLove(int articleId) {
		Article  article=articleMapper.selectByPrimaryKey(articleId);
		int love = article.getLove();
		if(love <= 0)
			love = 0;
		else {
			love--;
			article.setLove(love);
			articleMapper.updateByPrimaryKey(article);
		}
		return love;
	}
}
