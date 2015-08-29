package com.startup.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.dao.ClassMapper;
import com.startup.dao.ClassStudentMapper;
import com.startup.dao.StudentMapper;       
import com.startup.dao.TeacherMapper;
import com.startup.pojo.ClassStudent;
import com.startup.pojo.Student;            
import com.startup.pojo.Teacher;
import com.startup.service.LoginService;    

@Service("loginservice")
@Transactional
public class LoginServiceImpl implements LoginService {
	@Resource
	private StudentMapper studentMapper;

	@Resource
	private TeacherMapper teacherMapper;
	
	@Resource
	private ClassStudentMapper classStudentMapper;
	
	@Resource
	private ClassMapper classMapper;
	
	@Override
	public int validate(String studentEmail,String studentPassword){
		Student student= studentMapper.selectByStudentEmail(studentEmail);
		if(student == null)
			return USER_NOT_EXITS;
		else{
			if(student.getPasswords().equals(studentPassword))
				return USER_LOGIN_SUC;
			else
				return USER_PWD_INVALID;
		}
	}
	
	@Override
	public int teacherValidate(String teacherEmail, String teacherPassword) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherMapper.selectByTeacherEmail(teacherEmail);
		if(teacher == null)
			return USER_NOT_EXITS;
		else {
			if(teacher.getPasswords().equals(teacherPassword))
				return USER_LOGIN_SUC;
			else
				return USER_PWD_INVALID;
		}
	}
	
	@Override
	public Student findStudentByEmail(String studentEmail) {
		Student student = studentMapper.selectByStudentEmail(studentEmail);
		return student;
	}

	@Override
	public Teacher findTeacherByEmail(String teacherEmail) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherMapper.selectByTeacherEmail(teacherEmail);
		return teacher;
	}

	@Override
	public String selectClassNoByStudentId(Integer stuId) {
		// TODO Auto-generated method stub
		ClassStudent classStudent = classStudentMapper.selectByStudentId(stuId);
		if(classStudent == null)
			return "0";
		else {
			int classId = classStudent.getClassid();
			int classNo = classMapper.selectByPrimaryKey(classId).getClassno();
			return String.valueOf(classNo);
		}
	}
}	
