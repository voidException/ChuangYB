package com.startup.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.service.CommentsService;
import com.startup.util.DateUtil;
import com.startup.vo.CommentsVo;
import com.startup.pojo.Comments;
import com.startup.pojo.Student;
import com.startup.pojo.Teacher;
import com.startup.dao.CommentsMapper;
import com.startup.dao.StudentMapper;
import com.startup.dao.ArticleMapper;
import com.startup.dao.TeacherMapper;
import com.startup.pojo.Article;

@Transactional
@Service("insertComments")
public class CommentsServiceImp implements CommentsService{
	
	@Resource 
	private CommentsMapper  commentsMapper;
	
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public int insertComment(Comments comments){
		
	    commentsMapper.insert(comments);	
		Article article=articleMapper.selectByPrimaryKey(comments.getArticleid());
		int commentsNum=article.getComments() + 1;
		article.setComments(commentsNum);
		articleMapper.updateByPrimaryKeySelective(article);
		return commentsNum;
	}

	@Override 
	public List<Comments> getComments(Map<String,Integer> map){
		List<Comments> comments= commentsMapper.selectByArticlePrimaryKey(map);
		return comments;
	}
	
	@Override
	public int deleteComment(Integer commentiD) {
		int result = commentsMapper.deleteByPrimaryKey(commentiD);
		return result;
	}

	//删除一条评论，同时对应文章表里的评论数减一
	@Override
	public int ifCommentExist(Integer commentiD) {
		Comments comments = commentsMapper.selectByPrimaryKey(commentiD);
		if(comments == null)
			return 0;
		else {
			Article article = articleMapper.selectByPrimaryKey(comments.getArticleid());
			int commentsNum = article.getComments() - 1;
			article.setComments(commentsNum);
			int result = articleMapper.updateByPrimaryKey(article);
			return result;
		}
	}

	@Override
	public List<CommentsVo> getCommentsVo(List<Comments> listComments) {
		List<CommentsVo> commentsVos = new ArrayList<CommentsVo>();
		for(int i = 0; i<listComments.size(); i++) {
			CommentsVo commentsVo = new CommentsVo();
			commentsVo.setComments(listComments.get(i));
			
			int userId = listComments.get(i).getUserid();
			//userId语义见后台文档说明
			if(userId%10 == 1) {
				Student student = studentMapper.selectByPrimaryKey(userId/10);
				if(student == null)
					commentsVo.setUserPhotoPath("");
				else
					commentsVo.setUserPhotoPath(student.getPhoto());
			} else if(userId%10 == 2) {
				Teacher teacher = teacherMapper.selectByPrimaryKey(userId/10);
				if(teacher == null)
					commentsVo.setUserPhotoPath("");
				else
					commentsVo.setUserPhotoPath(teacher.getPhoto());
			} else {
				commentsVo.setUserPhotoPath("");
			}
			
			String dateStr = DateUtil.getDateString2(listComments.get(i).getCommenttime());
			commentsVo.setTimeString(dateStr);
			commentsVos.add(commentsVo);
		}
		return commentsVos;
	}
		
}

