package com.startup.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.startup.pojo.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.startup.vo.BaseVo;
import com.startup.service.ArticleService;
import com.startup.service.StudentClassService;
import com.startup.service.TeacherClassService;
import com.startup.vo.AddCommentVo;
import com.startup.vo.CommentsListVo;
import com.startup.vo.CommentsPostVo;
import com.startup.vo.DelCommentVo;
import com.startup.vo.IntVo;
import com.startup.vo.SpecificArticleVo;
import com.startup.vo.ArticlePostVo;
import com.startup.service.CommentsService;
import com.startup.pojo.Comments;
import com.startup.vo.LovePostVo;

@Controller
@RequestMapping(value="jsp")
public class ArticleControllerJSP {
	@Resource
	private  ArticleService articleService;
	
	@RequestMapping(value="/getArticleJSP/{articleid}")
	public  String getArticle(@PathVariable Integer articleid,Model model){
		//根据文章的articleid返回文章
		Article article = articleService.getArticle(articleid);
		model.addAttribute("article", article);
		return "/front/article";
	}
	

}


















