package com.startup.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.dao.StudentMapper;
import com.startup.dao.TeacherMapper;
import com.startup.pojo.Student;
import com.startup.pojo.Teacher;
import com.startup.service.RegisterService;
import com.startup.util.Paging;
import com.startup.vo.StudentVo;
import com.startup.vo.TeacherRegisterVo;



@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService{
	
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public int registerValidate(StudentVo studentVo) {
		// TODO Auto-generated method stub
		if(studentVo.getStuName().length()<2||studentVo.getStuName().length()>12)
			return USER_NAME_INVALID;
		else if(studentVo.getStuNo() == null||studentVo.getStuNo().length()>15)
			return USER_NO_INVALID;
		else if(studentVo.getStuPassword().length()<6||studentVo.getStuPassword().length()>15)
			return USER_PASSWORD_INVALID;
		else if(studentVo.getStuPassword().compareTo(studentVo.getStuPasswordRepeat()) != 0)
			return USER_PASSWORD_DIFFERENT;
		else{
			//验证邮箱格式是否合法
			//String pat="[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9]+(\\.(com))";  
			String pat = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
	        Pattern p = Pattern.compile(pat);//实例化Pattern类  
	        Matcher m = p.matcher(studentVo.getStuEmail());//验证内容是否合法
	        if(m.matches() == false)
	        	return USER_EMAIL_INVALID;
	        else{
	        	Student student = studentMapper.selectByStudentEmail(studentVo.getStuEmail());
	        	if(null == student)
	        		return USER_REGISTER_SUC;
	        	else
	        		return USER_EMAIL_REPEAT;
	        }
		}
	}

	@Override
	public int teacherRegisterValidate(TeacherRegisterVo teacherRegisterVo) {
		// TODO Auto-generated method stub
		if(teacherRegisterVo.getTeacherName().length()<2||teacherRegisterVo.getTeacherName().length()>12)
			return USER_NAME_INVALID;
		else if(teacherRegisterVo.getPassword().length()<6||teacherRegisterVo.getPassword().length()>15)
			return USER_PASSWORD_INVALID;
		else if(teacherRegisterVo.getPasswordRepeat().compareTo(teacherRegisterVo.getPassword()) != 0)
			return USER_PASSWORD_DIFFERENT;
		else{
			//验证邮箱格式是否合法
			//String pat="[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9]+(\\.(com))";  
			String pat = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
	        Pattern p = Pattern.compile(pat);//实例化Pattern类  
	        Matcher m = p.matcher(teacherRegisterVo.getTeacherEmail());//验证内容是否合法
	        if(m.matches() == false)
	        	return USER_EMAIL_INVALID;
	        else{
	        	Teacher teacher = teacherMapper.selectByTeacherEmail(teacherRegisterVo.getTeacherEmail());
	        	if(null == teacher)
	        		return USER_REGISTER_SUC;
	        	else
	        		return USER_EMAIL_REPEAT;
	        }
		}
	}

	
	@Override
	public int registerInsertData(StudentVo studentVo) {
		// TODO Auto-generated method stub
		//插入注册信息
		Student student = new Student();
		student.setStuname(studentVo.getStuName());
		student.setPasswords(studentVo.getStuPassword());
		student.setStuno(studentVo.getStuNo());
		student.setEmail(studentVo.getStuEmail());
	    
		int result = studentMapper.insert(student);
		return result;
	}
	
	@Override
	public int teacherRegisterInsertData(TeacherRegisterVo teacherRegisterVo) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setEmail(teacherRegisterVo.getTeacherEmail());
		teacher.setPasswords(teacherRegisterVo.getPassword());
		teacher.setTeachername(teacherRegisterVo.getTeacherName());
		
		int result = teacherMapper.insert(teacher);
		return result;
	}
	
	@Override
	public List<Student> findStudents(Paging paging) {
		List<Student> students = studentMapper.selectStudentsEmail(paging);
		for (Student student : students) {
			System.out.println(student);
		}
		return students;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		int result = teacherMapper.updateByPrimaryKey(teacher);
		return result;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		int result = studentMapper.updateByPrimaryKey(student);
		return result;
	}

	
}
