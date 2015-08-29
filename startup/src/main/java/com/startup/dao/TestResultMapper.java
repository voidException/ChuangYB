package com.startup.dao;

import java.util.List;
import java.util.Map;

import com.startup.pojo.TestResult;

public interface TestResultMapper {
    int deleteByPrimaryKey(Integer testresultid);

    int insert(TestResult record);

    int insertSelective(TestResult record);

    TestResult selectByPrimaryKey(Integer testresultid);
    List<TestResult> selectByStuIdItemIdClassId(Map<String, Integer> params);

    int updateByPrimaryKeySelective(TestResult record);

    int updateByPrimaryKey(TestResult record);

	TestResult selectByStuIdItemIdClassIdTestNo(Map<String, Integer> params);

	List<TestResult> selectByClassIdItemIdTestNo(Map<String, Integer> params);

	List<TestResult> selectByStuIdClassIdTestNo(Map<String, Integer> params);

}