package com.startup.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.pojo.Test;
import com.startup.pojo.TestResult;
import com.startup.service.StudentTestService;
import com.startup.vo.BaseVo;
import com.startup.vo.ItemStudentClassIdVo;
import com.startup.vo.TestResultVo;
import com.startup.vo.TestVo;

/**
 * 
 * @author LiuFeng
 *
 */

@Controller
@RequestMapping("/student/test")
public class StudentTestController {
	@Resource
	private StudentTestService studentTestService;
	
	//发送题组id，返回题组的所有题目信息（题组未测试）
	@RequestMapping(value = "/getTest",method = RequestMethod.GET)
	public @ResponseBody TestVo getTest(int itemId){
		TestVo testVo = new TestVo();
		if(studentTestService.ifItemExist(itemId) == 0){
			testVo.setError(0);
			testVo.setErrorMessage("没有这个题组呀");
			testVo.setTest(null);
		}else{
			testVo.setError(1);
			testVo.setErrorMessage("成功返回题目");
			testVo.setTest(studentTestService.findTestByItemId(itemId));
		}
		return testVo;
	}
	
	//发送班级id，学生id，题组id，返回学生此题目的结果
	@RequestMapping(value = "/getTestResult",method = RequestMethod.POST)
	public @ResponseBody TestResultVo getTestResult(@RequestBody ItemStudentClassIdVo itemStudentClassIdVo){
		
		TestResultVo testResultVo = new TestResultVo();
		if(studentTestService.ifTestResultExist(itemStudentClassIdVo) == 0){
			testResultVo.setError(0);
			testResultVo.setErrorMessage("找不到这个结果呢");
			testResultVo.setTestResult(null);
		}else{
			testResultVo.setError(1);
			testResultVo.setErrorMessage("成功返回结果");
			testResultVo.setTestResult(studentTestService.findTestResultByStuIdItemIdClassId(itemStudentClassIdVo));
		}
		return testResultVo;
	}
	
	//提交学生题目结果
	@RequestMapping(value = "/addTestResult",method = RequestMethod.POST)
	public @ResponseBody BaseVo addTestResult(@RequestBody TestResultVo testResultVo){
		BaseVo baseVo = new BaseVo();
		int flag = 0;
		for(int i = 0; i<testResultVo.getTestResult().size();i++)
			if(studentTestService.insertTestResult(testResultVo.getTestResult().get(i)) == 0)
				flag++;
		if(flag == 0){
			baseVo.setError(0);//error= 0表示错误数为0
			baseVo.setErrorMessage("都插入成功啦");
		}else{
			baseVo.setError(flag);//error表示错误数
			baseVo.setErrorMessage("有"+flag+"条数据插入出错了");
		}
		return baseVo;
	}
	
	//清空学生题目结果
	@RequestMapping(value = "/deleteTestResult", method = RequestMethod.POST)
	public @ResponseBody BaseVo deleteTestResult(@RequestBody ItemStudentClassIdVo itemStudentClassIdVo) {
		BaseVo baseVo = new BaseVo();
		int flag = 0;
		List<TestResult> testResults = studentTestService.findTestResultByStuIdItemIdClassId(itemStudentClassIdVo);
		for(int i=0; i<testResults.size();i++) {
			int result = studentTestService.deleteTestResult(testResults.get(i));
			if(result != 0)
				flag++;
		}
		baseVo.setError(flag);
		baseVo.setErrorMessage("删除了"+flag+"条数据");
		return baseVo;
	}
}
