package com.startup.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.dao.ItemToTestMapper;
import com.startup.dao.TestMapper;
import com.startup.dao.TestResultMapper;
import com.startup.pojo.ItemToTest;
import com.startup.pojo.Test;
import com.startup.pojo.TestResult;
import com.startup.service.StudentTestService;
import com.startup.vo.ItemStudentClassIdVo;

@Service
@Transactional
public class StudentTestServiceImpl implements StudentTestService{
	
	@Resource
	private ItemToTestMapper itemToTestMapper;
	
	@Resource
	private TestMapper testMapper;
	
	@Resource
	private TestResultMapper testResultMapper;
	
	//判断题组是否存在，存在返回1，不存在返回0
	@Override
	public int ifItemExist(int itemId) {
		// TODO Auto-generated method stub
		List<ItemToTest> itemToTests = itemToTestMapper.selectByItemId(itemId);
		if(itemToTests.size() == 0)
			return 0;
		else
			return 1;
	}

	//找到题组所对应的题目
	@Override
	@Cacheable(value="accountCache")
	public List<Test> findTestByItemId(int itemId) {
		// TODO Auto-generated method stub
		List<Test> tests = new ArrayList<Test>();
		List<ItemToTest> itemToTests = itemToTestMapper.selectByItemId(itemId);
		//已经按照照题号排序
		for(int i = 0; i < itemToTests.size(); i++)
			tests.add(testMapper.selectByPrimaryKey(itemToTests.get(i).getTestid()));
		return tests;
	}

	//找到结果是否存在
	@Override
	public int ifTestResultExist(ItemStudentClassIdVo itemStudentClassIdVo) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("stuId", itemStudentClassIdVo.getStuId());
		params.put("itemId", itemStudentClassIdVo.getItemId());
		params.put("classId", itemStudentClassIdVo.getClassId());
		List<TestResult> testResults = testResultMapper.selectByStuIdItemIdClassId(params);
		if(testResults.size() == 0)
			return 0;
		else
			return 1;
	}
	
	//找到学生班级题组对应的结果
	@Override
	public List<TestResult> findTestResultByStuIdItemIdClassId(
			ItemStudentClassIdVo itemStudentClassIdVo) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("stuId", itemStudentClassIdVo.getStuId());
		params.put("itemId", itemStudentClassIdVo.getItemId());
		params.put("classId", itemStudentClassIdVo.getClassId());
		List<TestResult> testResults = testResultMapper.selectByStuIdItemIdClassId(params);
		return testResults;
	}

	//插入学生做题结果
	@Override
	public int insertTestResult(TestResult testResult) {
		// TODO Auto-generated method stub
		int result = 0;
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("stuId", testResult.getStuid());
		params.put("classId", testResult.getClassid());
		params.put("ItemId",testResult.getItemid());
		params.put("testNo", testResult.getTestno());
		TestResult existTestResult = testResultMapper.selectByStuIdItemIdClassIdTestNo(params);
		if(existTestResult != null)
			result = testResultMapper.deleteByPrimaryKey(existTestResult.getTestresultid());
		result = testResultMapper.insert(testResult);
		return result;
	}

	@Override
	public int deleteTestResult(TestResult testResult) {
		// TODO Auto-generated method stub
		int result = testResultMapper.deleteByPrimaryKey(testResult.getTestresultid());
		return result;
	}
}
