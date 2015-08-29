package com.startup.controller;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.ArticleListService;
import com.startup.vo.ArticleListPostVo;
import com.startup.vo.ArticleVo;
import com.startup.pojo.Article;

@Controller
@RequestMapping(value="/jsp")
public class ArticleListControllerJSP {
	@Resource 
	private ArticleListService  articleListService;
	
	@RequestMapping(value="/article/{ttag}/{ppage}/{ppageSize}")
	public String  getArticleList(@PathVariable int ttag,@PathVariable int ppage, @PathVariable int ppageSize,Model model){
		int tag=ttag;
		int page=ppage;
		int pageSize=ppageSize;
		Map<String,Integer> map=new HashMap<String,Integer>();
		ArticleVo articleVo=new ArticleVo();
		List<Article> listArticles=new ArrayList<Article>();
		if (tag==11){
			map.put("labelOne",tag);
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
			return "/back/advise";  //这里应该定位到404错误
		}
		listArticles = articleListService.getListArticles(map);
		model.addAttribute("moocs",listArticles);
		return "/front/courseList";
	}		
		
}





















