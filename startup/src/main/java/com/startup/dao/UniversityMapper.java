package com.startup.dao;

import com.startup.pojo.University;

public interface UniversityMapper {
    int deleteByPrimaryKey(Integer universityid);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer universityid);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);
}