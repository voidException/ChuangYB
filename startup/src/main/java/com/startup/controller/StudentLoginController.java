package com.startup.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.LoginService;
import com.startup.service.StudentClassService;
import com.startup.vo.BaseVo;
import com.startup.vo.StudentLoginVo;
import com.startup.mail.JavaUtil;
import com.startup.pojo.Student;
import com.startup.vo.StudentInfoVo;

@Controller
@RequestMapping("/student")
public class StudentLoginController {
	@Resource
	private LoginService   loginService;		
	
	@Resource
	private StudentClassService studentClassService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody StudentInfoVo login(@RequestBody StudentLoginVo studentLoginVo){
		int flag=loginService.validate(studentLoginVo.getStudentEmail(), studentLoginVo.getStudentPassword());		
		StudentInfoVo studentInfoVo=new StudentInfoVo();
		studentInfoVo.setError(flag);
		if(flag==0)
			studentInfoVo.setErrorMessage("学生用户不存在");
		else if(flag==1)
			studentInfoVo.setErrorMessage("登录成功");
		else
			studentInfoVo.setErrorMessage("密码错误");
		Student student = loginService.findStudentByEmail(studentLoginVo.getStudentEmail());
		if(student != null)
			student.setRoomno(loginService.selectClassNoByStudentId(student.getStuid()));
		studentInfoVo.setStudent(student);
		return studentInfoVo;
	}
	

	@RequestMapping(value="/loginn")
	public @ResponseBody StudentInfoVo login2(HttpServletRequest request){
		 String result = "?后面的参数为：" + request.getQueryString();
		 System.out.println(result);
		
		StudentInfoVo studentInfoVo=new StudentInfoVo();
		int flag=1;
		studentInfoVo.setError(flag);
		if(flag==0)
			studentInfoVo.setErrorMessage("学生用户不存在");
		else if(flag==1)
			studentInfoVo.setErrorMessage("登录成功");
		else
			studentInfoVo.setErrorMessage("密码错误");
		
		return studentInfoVo;
	}	
	
	
	
	
	@RequestMapping(value = "/findPassword", method = RequestMethod.GET)
	public @ResponseBody BaseVo findPassword(String stuEmail) {
		BaseVo baseVo = new BaseVo();
		JavaUtil javaUtil = new JavaUtil();
		Student student = loginService.findStudentByEmail(stuEmail);
		if(student == null) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这个学生");
		}else {
			baseVo.setError(1); 
			baseVo.setErrorMessage("已经发送邮件");
			javaUtil.sendEmail("zachary0513@126.com", student.getPasswords());
		}
		return baseVo;
	}
	
	
	
	
	
	
}
