package com.startup.service;

import com.startup.pojo.Student;
import com.startup.pojo.Teacher;

public interface LoginService {
	public static final int USER_NOT_EXITS = 0;		    //用户不存在
	public static final int USER_PWD_INVALID = 2;		//密码不正确
	public static final int USER_LOGIN_SUC = 1;		    //登陆成功
	
	public int validate(String studentEmail,String studentPassword);
	
	public Student findStudentByEmail(String StudentEmail);

	public Teacher findTeacherByEmail(String teacherEmail);

	public int teacherValidate(String teacherEmail, String teacherPassword);

	public String selectClassNoByStudentId(Integer stuid);

	
}
