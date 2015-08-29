package com.startup.dao;

import java.util.List;

import com.startup.pojo.TeachClass;

public interface TeachClassMapper {
    int deleteByPrimaryKey(Integer teachclassid);

    int insert(TeachClass record);

    int insertSelective(TeachClass record);

    TeachClass selectByPrimaryKey(Integer teachclassid);

    int updateByPrimaryKeySelective(TeachClass record);

    int updateByPrimaryKey(TeachClass record);

	TeachClass selectByClassId(int classId);

	List<TeachClass> selectByTeacherId(int teacherId);
}