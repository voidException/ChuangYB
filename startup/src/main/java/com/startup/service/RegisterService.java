package com.startup.service;

import java.util.List;

import com.startup.pojo.Student;
import com.startup.pojo.Teacher;
import com.startup.util.Paging;
import com.startup.vo.StudentVo;
import com.startup.vo.TeacherRegisterVo;

/**
 * 
 * @author LiuFeng
 * 
 */

public interface RegisterService {
	public static final int USER_EMAIL_INVALID = 1; //注册邮箱不合法
	public static final int USER_EMAIL_REPEAT = 2; //邮箱已经被注册过
	public static final int USER_NAME_INVALID = 3; //真实姓名不合法
	public static final int USER_PASSWORD_INVALID = 4;//密码不合法
	public static final int USER_PASSWORD_DIFFERENT = 5;//两次密码不同
	public static final int USER_NO_INVALID = 6;//学号学工号不合法
	public static final int USER_REGISTER_SUC = 9;//注册成功
	public int registerValidate(StudentVo student);
	
	public int registerInsertData(StudentVo student);
	
	public List<Student> findStudents(Paging paging);

	public int teacherRegisterValidate(TeacherRegisterVo teacherRegisterVo);

	public int teacherRegisterInsertData(TeacherRegisterVo teacherRegisterVo);

	public int updateTeacher(Teacher teacher);

	public int updateStudent(Student student);
}
