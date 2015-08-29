package com.startup.service;
import com.startup.pojo.Comments;
import com.startup.vo.CommentsVo;

import java.util.List;
import java.util.Map;

public interface CommentsService {
	
	public int insertComment(Comments record);
	
	public List<Comments> getComments(Map<String,Integer> map);
	
	public int deleteComment(Integer commentiD);

	public int ifCommentExist(Integer commentiD);

	public List<CommentsVo> getCommentsVo(List<Comments> listComments);
	
}
