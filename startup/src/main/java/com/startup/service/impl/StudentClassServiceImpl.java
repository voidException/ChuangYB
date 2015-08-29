package com.startup.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.dao.ClassMapper;
import com.startup.dao.ClassStudentMapper;
import com.startup.dao.ItemTestMapper;
import com.startup.dao.StudentMapper;
import com.startup.dao.TeachClassMapper;
import com.startup.dao.TeacherMapper;
import com.startup.dao.TestResultMapper;
import com.startup.dao.UnameMapper;
import com.startup.pojo.ClassStudent;
import com.startup.pojo.ItemTest;
import com.startup.pojo.Student;
import com.startup.pojo.TeachClass;
import com.startup.pojo.Teacher;
import com.startup.pojo.TestResult;
import com.startup.pojo.Uname;
import com.startup.pojo.Class;
import com.startup.service.StudentClassService;
import com.startup.vo.StudentTwoVo;

@Service("studentClassService")
@Transactional
public class StudentClassServiceImpl implements StudentClassService{
	@Resource
	private ClassStudentMapper classStudentMapper;
	
	@Resource
	private UnameMapper unameMapper;
	
	@Resource
	private ItemTestMapper itemTestMapper;
	
	@Resource
	private ClassMapper classMapper;
	
	@Resource
	private TestResultMapper testResultMapper;

	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Resource
	private TeachClassMapper teachClassMapper;
	
	//通过学生id查找学生对应的班级id，如果学生没有加入班级则返回零
	@Override
	public int selectClassIdByStudentId(int stuId) {
		// TODO Auto-generated method stub
		ClassStudent classStudent = classStudentMapper.selectByStudentId(stuId);
		if(classStudent == null)
			return 0;
		else
			return classStudent.getClassid();
	}

	//通过班级号查找题组并返回题组状态，激活，未激活，未测试，已测试,
	@Override
	public List<ItemTest> selectItemTestByClassId(int classId, int stuId) {
		// TODO Auto-generated method stub
		//通过班级号找到未名表的题组
		List<Uname> unames = unameMapper.selectByClassId(classId);
		List<ItemTest> itemTests = new ArrayList<ItemTest>();
		int flag = 0;
		//找到班级的题组并返回题组内容以及题组状态
		for(int i = 0; i < unames.size(); i++){
			//每一条题组添加到要返回的题组
			itemTests.add(itemTestMapper.selectByPrimaryKey(unames.get(i).getItemid()));
			//在学生成绩表里找到对应题组，以判别是否测试过
			Map<String, Integer> params = new HashMap<String, Integer>();
			params.put("stuId", stuId);
			params.put("itemId", unames.get(i).getItemid());
			params.put("classId", classId);
			List<TestResult> testResults = testResultMapper.selectByStuIdItemIdClassId(params);
			//判别学生是否测试，flag=0表示未测试，flag=1表示已经测试
			if(testResults.size() == 0)
				flag = 0;
			else
				flag = testResults.get(0).getState();
			//返回题组状态一共四个状态
			if(unames.get(i).getActivity() ==  0){
				//如果未激活未测试则返回1
				if(flag == 0)
					itemTests.get(i).setActivity(1);
				//如果未激活已测试则返回2
				else
					itemTests.get(i).setActivity(2);
			}else{
				//如果已激活未测试则返回3
				if(flag == 0)
					itemTests.get(i).setActivity(3);
				//如果已激活已测试则返回4
				else
					itemTests.get(i).setActivity(4);
			}
		}
		return itemTests;
	}

	//返回0代表没有此班级，返回1代表有此班级
	@Override
	public int IfClassIdExist(int classId) {
		// TODO Auto-generated method stub
		Class oneClass = classMapper.selectByPrimaryKey(classId);
		if(oneClass == null)
			return 0;
		else 
			return 1;
	}

	//学生加入新班级，插入班级-学生表
	@Override
	public int StudentAddClass(int classId, int stuId) {
		// TODO Auto-generated method stub
		ClassStudent classStudent = new ClassStudent();
		classStudent.setClassid(classId);
		classStudent.setStuid(stuId);
		Class oneClass = classMapper.selectByPrimaryKey(classId);
		int realStudentNumber = oneClass.getRealstudentnum() + 1;
		oneClass.setRealstudentnum(realStudentNumber);
		classMapper.updateByPrimaryKey(oneClass);
		int result = classStudentMapper.insert(classStudent);
		return result;
	}

	@Override
	public int IfStuIdExist(int stuId) {
		// TODO Auto-generated method stub
		Student student = studentMapper.selectByPrimaryKey(stuId);
		if(student == null)
			return 0;
		else
			return 1;
	}

	@Override
	public int IfClassStudentExist(int stuId, int classId) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("stuId", stuId);
		params.put("classId",classId);
		ClassStudent classStudent = classStudentMapper.selectByStuIdClassId(params);
		if(classStudent == null)
			return 0;
		else
			return 1;
	}

	@Override
	public int findClassIdByClassNo(int classNo) {
		// TODO Auto-generated method stub
		Class oneClass = classMapper.selectByClassNo(classNo);
		if(oneClass == null)
			return 0;
		else
			return oneClass.getClassid();
	}

	@Override
	public Class findClassByClassId(int classId) {
		// TODO Auto-generated method stub
		Class oneClass = classMapper.selectByPrimaryKey(classId);
		return oneClass;
	}

	@Override
	public Teacher findTeacherByclassId(int classId) {
		// TODO Auto-generated method stub
		TeachClass teacherClass = teachClassMapper.selectByClassId(classId);
		if(teacherClass == null)
			return null;
		else {
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherClass.getTeacherid());
		return teacher;
		}
	}

	@Override
	public List<StudentTwoVo> findStudentTwoVoByClassId(int classId) {
		// TODO Auto-generated method stub
		List<StudentTwoVo> studentTwoVos = new ArrayList<StudentTwoVo>();
		List<ClassStudent> classStudents = classStudentMapper.selectByClassId(classId);
		for(int i = 0; i<classStudents.size(); i++) {
			StudentTwoVo studentTwoVo = new StudentTwoVo();
			studentTwoVo.setStuId(classStudents.get(i).getStuid());
			studentTwoVo.setStuName(studentMapper.selectByPrimaryKey(classStudents.get(i).getStuid()).getStuname());
			studentTwoVo.setStuNo(studentMapper.selectByPrimaryKey(classStudents.get(i).getStuid()).getStuno());
			studentTwoVo.setStuPhoto(studentMapper.selectByPrimaryKey(classStudents.get(i).getStuid()).getPhoto());
			studentTwoVos.add(studentTwoVo);
		}
		return studentTwoVos;
	}

	@Override
	public int StudentQuitClass(int stuId, int classId) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("stuId", stuId);
		params.put("classId", classId);
		
		Class oneClass = classMapper.selectByPrimaryKey(classId);
		int realStudentNumber = oneClass.getRealstudentnum() - 1;
		oneClass.setRealstudentnum(realStudentNumber);
		classMapper.updateByPrimaryKey(oneClass);
		int result = classStudentMapper.deleteByStuIdClassId(params);
		return result;
	}

	@Override
	public int UpdateStudentPhoto(String uploadImagePath, int id) {
		// TODO Auto-generated method stub
		Student student = studentMapper.selectByPrimaryKey(id);
		student.setPhoto(uploadImagePath);
		int result = studentMapper.updateByPrimaryKey(student);
		return result;
	}

}
