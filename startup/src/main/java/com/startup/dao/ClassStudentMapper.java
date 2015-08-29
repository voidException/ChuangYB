package com.startup.dao;

import java.util.List;
import java.util.Map;

import com.startup.pojo.ClassStudent;
import com.startup.pojo.Student;

public interface ClassStudentMapper {
    int deleteByPrimaryKey(Integer classstuid);

    int insert(ClassStudent record);

    int insertSelective(ClassStudent record);

    ClassStudent selectByPrimaryKey(Integer classstuid);
    ClassStudent selectByStudentId(Integer stuId);

    int updateByPrimaryKeySelective(ClassStudent record);

    int updateByPrimaryKey(ClassStudent record);

	ClassStudent selectByStuIdClassId(Map<String, Integer> params);

	List<ClassStudent> selectByClassId(int classId);

	int deleteByStuIdClassId(Map<String, Integer> params);
}