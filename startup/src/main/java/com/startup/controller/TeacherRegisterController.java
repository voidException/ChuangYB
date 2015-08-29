package com.startup.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.pojo.Teacher;
import com.startup.service.RegisterService;
import com.startup.service.TeacherClassService;
import com.startup.vo.BaseVo;
import com.startup.vo.TeacherRegisterVo;

@Controller
@RequestMapping("/teacher")
public class TeacherRegisterController {
	@Resource
	private RegisterService registerService;
	
	@Resource
	private TeacherClassService teacherClassService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public @ResponseBody BaseVo register(@RequestBody TeacherRegisterVo teacherRegisterVo) {
		BaseVo baseVo = new BaseVo();
		int flag = registerService.teacherRegisterValidate(teacherRegisterVo);
		if(RegisterService.USER_REGISTER_SUC == flag)
			registerService.teacherRegisterInsertData(teacherRegisterVo);
		baseVo.setError(flag);
		if(flag == 1)
			baseVo.setErrorMessage("注册邮箱不合法");
		else if(flag == 2)
			baseVo.setErrorMessage("邮箱已经注册过了");
		else if(flag == 3)
			baseVo.setErrorMessage("真实姓名不合法");
		else if(flag == 4)
			baseVo.setErrorMessage("密码不合法");
		else if(flag == 5)
			baseVo.setErrorMessage("两次密码不同");
		else 
			baseVo.setErrorMessage("老师注册成功");
		return baseVo;
	}
	
	@RequestMapping(value = "/changeInfo",method = RequestMethod.POST)
	public @ResponseBody BaseVo changeInfo(@RequestBody Teacher teacher) {
		BaseVo baseVo = new BaseVo();
		int teacherId = teacher.getTeacherid();
		if(teacherClassService.IfTeacherIdExist(teacherId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("老师不存在");
		}else {
			baseVo.setError(1);
			baseVo.setErrorMessage("成功修改信息");
			registerService.updateTeacher(teacher);
		}
		return baseVo;
	}
}