package com.startup.dao;

import com.startup.pojo.Comments;
import java.util.List;
import java.util.Map;
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer commentid);
    
    List<Comments> selectByArticlePrimaryKey(Map<String,Integer> map);
    
    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}