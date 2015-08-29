package com.startup.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.startup.service.ArticleListService;
import com.startup.util.GetPrivateAuth;
import com.startup.pojo.Article;
import com.startup.dao.ArticleMapper;
import java.util.Map;

@Service("articleListService")
@Transactional
public class ArticleListServiceImpl implements ArticleListService {
	@Resource
	private ArticleMapper  articleMapper;
		
	@Override
	public List<Article> getListArticles (Map<String,Integer> map){
		List<Article> articles=articleMapper.selectByTag(map);
		GetPrivateAuth getPrivateAuth = new GetPrivateAuth();
		for(int i = 0; i<articles.size(); i++) {
			String miniPhotoUrl = getPrivateAuth.privateDownloadUrl(articles.get(i).getMiniphotourl());
			articles.get(i).setMiniphotourl(miniPhotoUrl);
		}
		return articles;         
	}	   
}
