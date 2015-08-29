package com.startup.dao;

import com.startup.pojo.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Integer testid);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer testid);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}