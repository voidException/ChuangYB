package com.startup.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.dao.ClassMapper;
import com.startup.dao.ClassStudentMapper;
import com.startup.dao.ItemTestMapper;
import com.startup.dao.ItemToTestMapper;
import com.startup.dao.StudentMapper;
import com.startup.dao.TeachClassMapper;
import com.startup.dao.TeacherMapper;
import com.startup.dao.TestResultMapper;
import com.startup.dao.UnameMapper;
import com.startup.pojo.Class;
import com.startup.pojo.ClassStudent;
import com.startup.pojo.ItemTest;
import com.startup.pojo.ItemToTest;
import com.startup.pojo.Student;
import com.startup.pojo.TeachClass;
import com.startup.pojo.Teacher;
import com.startup.pojo.TestResult;
import com.startup.pojo.Uname;
import com.startup.service.TeacherClassService;
import com.startup.util.MyRandom;
import com.startup.vo.ClassTwoVo;
import com.startup.vo.CreateClassVo;
import com.startup.vo.ItemAccurateNumVo;
import com.startup.vo.StudentItemVo;
import com.startup.vo.StudentThreeVo;
import com.startup.vo.TeacherItemTwoVo;

@Service
@Transactional
public class TeacherClassServiceImpl implements TeacherClassService{
	@Resource
	private TeacherMapper teacherMapper;
	
	@Resource
	private TeachClassMapper teacherClassMapper;
	
	@Resource
	private ClassMapper classMapper;
	
	@Resource
	private UnameMapper unameMapper;
	
	@Resource
	private ItemTestMapper itemTestMapper;
	
	@Resource
	private TestResultMapper testResultMapper;
	
	@Resource
	private ItemToTestMapper itemToTestMapper;
	
	@Resource
	private ClassStudentMapper classStudentMapper;
	
	@Resource
	private StudentMapper studentMapper;
	
	@Override
	public int IfTeacherIdExist(int teacherId) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
		if(teacher == null)
			return 0;
		else 
			return 1;
	}

	@Override
	public List<Class> findClassByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		List<TeachClass> teachClasss = teacherClassMapper.selectByTeacherId(teacherId);
		List<Class> oneclasss = new ArrayList<Class>();
		for(int i = 0; i<teachClasss.size(); i++) {
			Class oneclass = classMapper.selectByPrimaryKey(teachClasss.get(i).getClassid());
			oneclasss.add(oneclass);
		}
		return oneclasss;
	}

	@Override
	public int createClass(CreateClassVo createClassVo) {
		String className = createClassVo.getClassName();
		String universityName = createClassVo.getUniversityName();
		int stuNum = createClassVo.getStudentNum();
		int teacherId = createClassVo.getTeacherId();
	    int classNo = 88888888;
	    
	    Class oneclass = new Class();
		oneclass.setClassroomname(className);
		oneclass.setStudentnum(stuNum);
		oneclass.setUniversityname(universityName);
		oneclass.setRealstudentnum(0);
		oneclass.setClassno(classNo);
		/*while(true) {
			Random randomno = new Random(); 
			classNo = randomno.nextInt(900000)+100000;
			Class twoclass = classMapper.selectByClassNo(classNo);
			if(twoclass == null) {
				oneclass.setClassno(classNo);
				break;
			}
		}*/
		classMapper.insert(oneclass);
		Class twoClass = classMapper.selectByClassNo(classNo);
		int classId = twoClass.getClassid();
		classNo = MyRandom.createClassNo(classId);
		twoClass.setClassno(classNo);
		classMapper.updateByPrimaryKey(twoClass);
		
		TeachClass teacherClass = new TeachClass();
		teacherClass.setClassid(classId);
		teacherClass.setTeacherid(teacherId);
		
		teacherClassMapper.insert(teacherClass);
		return classNo;
	}

	@Override
	public int changeClassMessage(ClassTwoVo classTwoVo) {
		// TODO Auto-generated method stub
		Class oneClass = classMapper.selectByPrimaryKey(classTwoVo.getClassId());
		oneClass.setClassroomname(classTwoVo.getClassName());
		oneClass.setPhoto(classTwoVo.getPhotoPath());
		oneClass.setUniversityname(classTwoVo.getUniversityName());
		oneClass.setStudentnum(classTwoVo.getMaxStudentNum());
		int result = classMapper.updateByPrimaryKey(oneClass);
		return result;
	}

	@Override
	public List<ItemTest> selectItemTestByClassId(int classId) {
		// TODO Auto-generated method stub
		List<Uname> unames = unameMapper.selectByClassId(classId);
		List<ItemTest> itemTests =  new ArrayList<ItemTest>();
		for(int i = 0; i < unames.size(); i++) {
			itemTests.add(itemTestMapper.selectByPrimaryKey(unames.get(i).getItemid()));
			itemTests.get(i).setActivity(unames.get(i).getActivity());
		}
		return itemTests;
	}

	@Override
	public int addItemToClass(int classId, int itemId) {
		// TODO Auto-generated method stub
		Uname uname = new Uname();
		uname.setClassid(classId);
		uname.setItemid(itemId);
		uname.setActivity(0);
		int result = unameMapper.insert(uname);
		return result;
	}

	@Override
	public int deleteItemFromClass(int classId, int itemId) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("classId", classId);
		params.put("itemId", itemId);
		int result = unameMapper.deleteByClassItemId(params);
		return result;
	}

	@Override
	public int updateItemFromClass(TeacherItemTwoVo teacherItemTwoVo) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("classId", teacherItemTwoVo.getClassId());
		params.put("itemId", teacherItemTwoVo.getItemId());
		Uname uname = unameMapper.selectByClassItemId(params);
		uname.setActivity(teacherItemTwoVo.getState());
		int result = unameMapper.updateByPrimaryKey(uname);
		return result;
	}

	@Override
	public List<ItemTest> getAllItem() {
		// TODO Auto-generated method stub
		List<ItemTest> itemTests = itemTestMapper.selectAllItem();
		return itemTests;
	}

	@Override
	public List<ItemAccurateNumVo> CalculateItemAccuracy(int classId, int itemId) {
		// TODO Auto-generated method stub
		List<ItemToTest> itemToTests = itemToTestMapper.selectByItemId(itemId);
		List<ItemAccurateNumVo> itemAccurateNumVos = new ArrayList<ItemAccurateNumVo>();
		for(int i = 0; i<itemToTests.size(); i++){
			ItemAccurateNumVo itemAccurateNumVo = new ItemAccurateNumVo();
			Map<String, Integer> params = new HashMap<String, Integer>();
			params.put("classId", classId);
			params.put("itemId", itemId);
			params.put("testNo", i+1);
			List<TestResult> testResults = testResultMapper.selectByClassIdItemIdTestNo(params);
			itemAccurateNumVo.setWholeNum(testResults.size());
			itemAccurateNumVo.setTestNo(i+1);
			int accurateNum = 0;
			for(int j = 0; j < testResults.size(); j++) 
				if(testResults.get(j).getTestresult()%10 == 1)
					accurateNum ++;
			itemAccurateNumVo.setAccurateNum(accurateNum);
			itemAccurateNumVos.add(itemAccurateNumVo);
		}
		return itemAccurateNumVos;
	}

	@Override
	public List<StudentThreeVo> CalculateStudentGrade(int classId) {
		List<ClassStudent> classStudents= classStudentMapper.selectByClassId(classId);
		List<StudentThreeVo> studentThreeVos = new ArrayList<StudentThreeVo>();
		for(int i = 0; i<classStudents.size(); i++) {
			StudentThreeVo studentThreeVo = new StudentThreeVo();
			int stuId = classStudents.get(i).getStuid();
			Student student = studentMapper.selectByPrimaryKey(stuId);
			studentThreeVo.setStuName(student.getStuname());
			studentThreeVo.setStuNo(student.getStuno());
			studentThreeVo.setStuPhoto(student.getPhoto());
			
			Map<String, Integer> params = new HashMap<String,Integer>();
			params.put("stuId", stuId);
			params.put("classId", classId);
			params.put("testNo", 1);
			List<TestResult> testResults = testResultMapper.selectByStuIdClassIdTestNo(params);
			int sum = 0;
			for(int j = 0; j<testResults.size(); j++) 
				sum += testResults.get(j).getItemresult();
			if(testResults.size() == 0)
				studentThreeVo.setStuGrade(0);
			else
				studentThreeVo.setStuGrade(sum/testResults.size());
			
			studentThreeVos.add(studentThreeVo);
		}
		return studentThreeVos;
	}

	@Override
	public int IfClassItemExist(int classId, int itemId) {
		// TODO Auto-generated method stub
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("classId", classId);
		params.put("itemId", itemId);
		Uname uname = unameMapper.selectByClassItemId(params);
		if(uname == null)
			return 0;
		else
			return 1;
	}

	@Override
	public int UpdateTeacherPhoto(String uploadImagePath, int id) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherMapper.selectByPrimaryKey(id);
		teacher.setPhoto(uploadImagePath);
		int result = teacherMapper.updateByPrimaryKey(teacher);
		return result;
	}

}
