package com.startup.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.ArticleListService;
import com.startup.vo.ArticleListPostVo;
import com.startup.vo.ArticleVo;
import com.startup.pojo.Article;

@Controller
@RequestMapping(value="/learn")
public class ArticleListController {
	
	@Resource 
	private ArticleListService  articleListService;
	
	@RequestMapping(value="/articleList",method=RequestMethod.POST)
	public @ResponseBody ArticleVo getArticleList(@RequestBody ArticleListPostVo articleListPostVo) {
		int tag=articleListPostVo.getTag();		
		int page=articleListPostVo.getPage();
		int pageSize=articleListPostVo.getPageSize();
		Map<String,Integer> map=new HashMap<String,Integer>();			
		ArticleVo articleVo = new ArticleVo();
		List<Article> listArticles=new ArrayList<Article>();
		 if(tag==11) {
			map.put("labelOne", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);		
		}else if(tag==21) {
			map.put("labelTwo", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==31) {
			map.put("labelThree", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==41) {
			map.put("labelFour", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==51) {
			map.put("labelFive", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==61) {
			map.put("labelSix", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==71 || tag==72 || tag==73) {//文字 图片 视频
			map.put("articleType", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);			
		}else if(tag==74) {
			map.put("love", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==76) {
			map.put("publishTime", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==77) {
			map.put("comments", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		}else if(tag==1) {
			map.put("labelZero", tag);
			map.put("page", page);
			map.put("pageSize", pageSize);
		} else {
			articleVo.setError(0);
			articleVo.setErrorMessage("出错了");
			articleVo.setArticle(null);
			return articleVo;
		}	
		listArticles = articleListService.getListArticles(map);
		if(listArticles == null) {
			articleVo.setError(0);
			articleVo.setErrorMessage("出错了");
			articleVo.setArticle(null);
		} else {
			articleVo.setError(1);
			articleVo.setErrorMessage("成功");
			articleVo.setArticle(listArticles);
		}
		return articleVo;		
	}	
}
