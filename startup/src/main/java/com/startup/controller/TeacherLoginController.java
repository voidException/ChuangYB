package com.startup.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.mail.JavaUtil;
import com.startup.pojo.Teacher;
import com.startup.service.LoginService;
import com.startup.vo.BaseVo;
import com.startup.vo.TeacherInfoVo;
import com.startup.vo.TeacherLoginVo;

@Controller
@RequestMapping("/teacher")
public class TeacherLoginController {
	@Resource 
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody TeacherInfoVo login(@RequestBody TeacherLoginVo teacherLoginVo) {
		int flag = loginService.teacherValidate(teacherLoginVo.getTeacherEmail(), teacherLoginVo.getTeacherPassword());
		TeacherInfoVo teacherInfoVo = new TeacherInfoVo();
		teacherInfoVo.setError(flag);
		Teacher teacher = loginService.findTeacherByEmail(teacherLoginVo.getTeacherEmail());
		if(flag == 0) {
			teacherInfoVo.setErrorMessage("老师用户不存在");
			teacherInfoVo.setTeacher(null);
		}else if(flag == 1) {
			teacherInfoVo.setErrorMessage("登录成功");
			teacherInfoVo.setTeacher(teacher);
		}else {
			teacherInfoVo.setErrorMessage("密码错误");
			teacherInfoVo.setTeacher(null);
		}
		teacherInfoVo.setTeacher(teacher);
		return teacherInfoVo;
	}
	
	@RequestMapping(value = "/findPassword", method = RequestMethod.GET)
	public @ResponseBody BaseVo findPassword(String teacherEmail) {
		BaseVo baseVo = new BaseVo();
		JavaUtil javaUtil = new JavaUtil();
		Teacher teacher = loginService.findTeacherByEmail(teacherEmail);
		if(teacher == null) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这个老师");
		}else {
			baseVo.setError(1);
			baseVo.setErrorMessage("已经发送邮件");
			for(int i = 0; i< 10; i++)
				javaUtil.sendEmail("zachary0513@126.com", teacher.getPasswords());
		}
		return baseVo;
	}
}