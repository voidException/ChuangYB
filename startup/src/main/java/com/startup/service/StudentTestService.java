package com.startup.service;

import java.util.List;

import com.startup.pojo.Test;
import com.startup.pojo.TestResult;
import com.startup.vo.ItemStudentClassIdVo;

public interface StudentTestService {

	//判断题组是否存在
	int ifItemExist(int itemId);

	//找到题组所对应的题目
	List<Test> findTestByItemId(int itemId);

	//找到结果是否存在
	int ifTestResultExist(ItemStudentClassIdVo itemStudentClassIdVo);

	//找到学生班级题组对应的结果
	List<TestResult> findTestResultByStuIdItemIdClassId(
			ItemStudentClassIdVo itemStudentClassIdVo);

	//插入学生做题结果
	int insertTestResult(TestResult testResult);

	int deleteTestResult(TestResult testResult);

}
