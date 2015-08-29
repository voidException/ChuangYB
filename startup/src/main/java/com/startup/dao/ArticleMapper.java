package com.startup.dao;
import java.util.List;

import java.util.Map;

import com.startup.pojo.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleid); 
    
    List<Article> selectByTag(Map<String,Integer> map);  //自定义方法，根据标签，页数，和每页大小返回一个集合。
  
    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
    
    int updateByPrimaryKeyTwo(Integer articleid);
    
}