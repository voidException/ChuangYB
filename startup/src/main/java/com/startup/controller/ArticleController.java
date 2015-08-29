package com.startup.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.startup.pojo.Article;

import org.springframework.stereotype.Controller;
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
@RequestMapping(value="/learn")
public class ArticleController {
	@Resource 
	private ArticleService articleService;
	
	@Resource
	private CommentsService commentsService;
	
	@Resource
	private StudentClassService studentClassService;
	
	@Resource
	private TeacherClassService teacherClassService;
	
	@RequestMapping(value="/article",method=RequestMethod.POST)
	public @ResponseBody SpecificArticleVo  getArticle(@RequestBody ArticlePostVo articlePostVo){
		SpecificArticleVo specificArticleVo=new SpecificArticleVo();
		Article article = articleService.getArticle(articlePostVo.getArticleiD());
		if(article == null){
			specificArticleVo.setError(0);
			specificArticleVo.setErrorMessage("获取文章失败");
			specificArticleVo.setArticle(null);
		}else{
			specificArticleVo.setError(1);
			specificArticleVo.setErrorMessage("获取文章成功");
			specificArticleVo.setArticle(article);
		}
		return specificArticleVo;
	}	
	
	@RequestMapping(value="/article/comment",method=RequestMethod.POST)
	public @ResponseBody IntVo addComments(@RequestBody AddCommentVo addCommentVo) {
		int articleId = addCommentVo.getArticleId();
		int userId = addCommentVo.getUserId();
		String content = addCommentVo.getContent();
		String userName = addCommentVo.getUserName();
		Date commentTime = addCommentVo.getCommentTime();
		Comments comments=new Comments();
		IntVo intVo=new IntVo();

		intVo.setNumber(0);
		if(articleService.IfArticleIdExist(articleId) == 0) {
			intVo.setError(0);
			intVo.setErrorMessage("没有这篇文章");
		} 
		else {
			int flag = 0;
			if(userId%10 == 1) {
				if(studentClassService.IfStuIdExist(userId/10) == 0) {
					intVo.setError(1);
					intVo.setErrorMessage("没有这个用户");
				} else {
					flag = 1;
				}
			} else if(userId%10 == 2) {
				if(teacherClassService.IfTeacherIdExist(userId/10) == 0) {
					intVo.setError(1);
					intVo.setErrorMessage("没有这个用户");
				} else {
					flag = 1;
				}
			} else {
				intVo.setError(1);
				intVo.setErrorMessage("没有这个用户");
			}
			
			if(flag == 1) {
				 comments.setArticleid(articleId);
				 comments.setCommenttime(commentTime);
				 comments.setContent(content);
				 comments.setUserid(userId);
				 comments.setUsername(userName);
				 int result=commentsService.insertComment(comments);
				 if(result == 0) {
					 intVo.setError(2);
					 intVo.setErrorMessage("插入失败");
					 intVo.setNumber(0);
				 }else{
					 intVo.setError(3);
					 intVo.setErrorMessage("插入成功");
				     intVo.setNumber(result);
				 }		
			}
		}
		return intVo;
	}	
	
	@RequestMapping(value="/article/delComment",method=RequestMethod.POST)
	public @ResponseBody BaseVo  deleteComment(@RequestBody  DelCommentVo delCommentVo){
		BaseVo baseVo = new BaseVo();
		if(commentsService.ifCommentExist(delCommentVo.getCommentiD()) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这条评论");
		} else {
			commentsService.deleteComment(delCommentVo.getCommentiD());
			baseVo.setError(1);
			baseVo.setErrorMessage("删除成功");
		}
		return baseVo;
	}

	@RequestMapping(value="/article/commentsList", method=RequestMethod.POST)
	public @ResponseBody CommentsListVo commentsList(@RequestBody CommentsPostVo commentsPostVo){
		CommentsListVo commentsListVo = new CommentsListVo(); 
		
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("articleiD", commentsPostVo.getArticleiD());
		params.put("page", commentsPostVo.getPage());
		params.put("pageSize", commentsPostVo.getPageSize());
		List<Comments> listComments = commentsService.getComments(params);
		if(listComments.size() == 0) {
			commentsListVo.setError(0);
			commentsListVo.setErrorMessage("出错了");
			commentsListVo.setCommentsVo(null);
		} else {
			commentsListVo.setError(1);
			commentsListVo.setErrorMessage("成功");
			commentsListVo.setCommentsVo(commentsService.getCommentsVo(listComments));
		}
		return commentsListVo;
	}	
	
	@RequestMapping(value="/article/addLove",method=RequestMethod.POST)
	public @ResponseBody IntVo  addLove(@RequestBody  LovePostVo  lovePostVo) {
		IntVo intVo = new IntVo();
		int articleId = lovePostVo.getArticleiD();
		if(articleService.IfArticleIdExist(articleId) == 0) {
			intVo.setError(0);
			intVo.setErrorMessage("没有这篇文章");
			intVo.setNumber(0);
		} else {
			int result = articleService.addLove(articleId);
			intVo.setError(1);
			intVo.setErrorMessage("返回赞的数量");
			intVo.setNumber(result);
		}
		return intVo;
	}
	
	@RequestMapping(value="/article/deleteLove",method=RequestMethod.POST)
	public @ResponseBody IntVo  deleteLove(@RequestBody  LovePostVo  lovePostVo) {
		IntVo intVo = new IntVo();
		int articleId = lovePostVo.getArticleiD();
		if(articleService.IfArticleIdExist(articleId) == 0) {
			intVo.setError(0);
			intVo.setErrorMessage("没有这篇文章");
			intVo.setNumber(0);
		} else {
			int result = articleService.deleteLove(articleId);
			intVo.setError(1);
			intVo.setErrorMessage("返回赞的数量");
			intVo.setNumber(result);
		}
		return intVo;
	}
}
