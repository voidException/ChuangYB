package com.startup.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.qiniu.util.Auth;
import com.startup.pojo.Student;
import com.startup.pojo.Teacher;
import com.startup.service.RegisterService;
import com.startup.service.StudentClassService;
import com.startup.util.Paging;
import com.startup.vo.StudentVo;
import com.startup.vo.BaseVo;
/**
 * 学生注册处理类
 * @author LiuFeng
 *
 */
@Controller
@RequestMapping("/student")
public class StudentRegisterController {
	@Resource
	private RegisterService registerService;
	
	@Resource
	private StudentClassService studentClassService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody StudentVo register(@RequestBody StudentVo studentVo){
		int flag = registerService.registerValidate(studentVo);
		if(RegisterService.USER_REGISTER_SUC == flag)
			registerService.registerInsertData(studentVo);
		studentVo.setError(flag);
		if(flag == 1)
			studentVo.setErrorMessage("注册邮箱不合法");
		else if(flag == 2)
			studentVo.setErrorMessage("邮箱已经注册过了");
		else if(flag == 3)
			studentVo.setErrorMessage("真实姓名不合法");
		else if(flag == 4)
			studentVo.setErrorMessage("密码不合法");
		else if(flag == 5)
			studentVo.setErrorMessage("两次密码不同");
		else if(flag == 6)
			studentVo.setErrorMessage("学号学工号不合法");
		else 
			studentVo.setErrorMessage("注册成功");
		return studentVo;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody List<Student> findStudents(@RequestBody Paging paging) {
		List<Student> students = registerService.findStudents(paging);
		return students;
	}
	
	@RequestMapping(value = "/changeInfo",method = RequestMethod.POST)
	public @ResponseBody BaseVo changeInfo(@RequestBody Student student) {
		BaseVo baseVo = new BaseVo();
		int studentId = student.getStuid();
		if(studentClassService.IfStuIdExist(studentId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("学生不存在");
		}else {
			baseVo.setError(1);
			baseVo.setErrorMessage("成功修改信息");
			registerService.updateStudent(student);
		}
		return baseVo;
	}
}
