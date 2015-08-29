  package com.startup.vo;

import java.util.List;

import com.startup.pojo.TestResult;

public class TestResultVo extends BaseVo {
	List<TestResult> testResult;

	public List<TestResult> getTestResult() {
		return testResult;
	}

	public void setTestResult(List<TestResult> testResult) {
		this.testResult = testResult;
	}
}
