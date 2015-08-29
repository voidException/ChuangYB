package com.startup.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.StudentClassService;
import com.startup.vo.BaseVo;
import com.startup.vo.ClassMessageVo;
import com.startup.vo.StudentItemVo;

/**
 * 
 * @author LiuFeng
 *
 */


@Controller
@RequestMapping("/student/class")
public class StudentClassController {
	@Resource
	private StudentClassService studentClassService;
	
	//发送学生id，获取其所属班级和班级题组以及题组状态，如果学生没有加入班级则返回班级号为0
	//不考虑一个学生加入多个班级的情况
	@RequestMapping(value = "/getItemtest",method = RequestMethod.GET)
	public @ResponseBody StudentItemVo getItemtest(int stuId){
		StudentItemVo studentItemVo = new StudentItemVo();
		if(studentClassService.IfStuIdExist(stuId) == 0){
			studentItemVo.setError(0);
			studentItemVo.setErrorMessage("没有这个学生");
			studentItemVo.setItemTest(null);
		}else{
			studentItemVo.setClassId(studentClassService.selectClassIdByStudentId(stuId));
			if(studentItemVo.getClassId() == 0){
				studentItemVo.setError(1);
				studentItemVo.setErrorMessage("学生没有加入班级呢");
				studentItemVo.setItemTest(null);
			}else{
				studentItemVo.setError(2);
				studentItemVo.setErrorMessage("学生已经加入班级啦");
				studentItemVo.setItemTest(studentClassService.selectItemTestByClassId(studentItemVo.getClassId(), stuId));
			}	
		}
		return studentItemVo;
	}
	
	//发送班级号，学生加入班级，并返回班级对应题组，如果班级不存在则返回班级号为0，题组为空
	@RequestMapping(value="/addClass",method = RequestMethod.GET)
	public @ResponseBody StudentItemVo addClass(int classNo,int stuId){
		StudentItemVo studentItemVo = new StudentItemVo();
		int classId = studentClassService.findClassIdByClassNo(classNo);
		if(studentClassService.IfClassIdExist(classId) == 0){
			studentItemVo.setError(0);
			studentItemVo.setErrorMessage("班级不存在");
			studentItemVo.setClassId(0);
			studentItemVo.setItemTest(null);
		}else if(studentClassService.IfStuIdExist(stuId) == 0){
			studentItemVo.setError(1);
			studentItemVo.setErrorMessage("学生不存在");
			studentItemVo.setClassId(0);
			studentItemVo.setItemTest(null);
		}else if(studentClassService.IfClassStudentExist(stuId, classId) != 0){
			studentItemVo.setError(2);
			studentItemVo.setErrorMessage("学生已经在班级里了");
			studentItemVo.setClassId(0);
			studentItemVo.setItemTest(null);
		}else{
			studentItemVo.setError(3);
			studentItemVo.setErrorMessage("学生成功加入班级");
			studentClassService.StudentAddClass(classId, stuId);
			studentItemVo.setClassId(classId);
			studentItemVo.setItemTest(studentClassService.selectItemTestByClassId(studentItemVo.getClassId(), stuId));
		}
		return studentItemVo;
	}
	
	//发送班级号，获取班级信息包括老师和学生头像，名字和学号
	@RequestMapping(value = "/getClassMessage", method = RequestMethod.GET)
	public @ResponseBody ClassMessageVo getClassMessage(int classNo) {
		ClassMessageVo classMessageVo = new ClassMessageVo();
		int classId = studentClassService.findClassIdByClassNo(classNo);
		if(studentClassService.IfClassIdExist(classId) == 0) {
			classMessageVo.setError(0);
			classMessageVo.setErrorMessage("班级不存在");
			classMessageVo.setOneClass(null);
			classMessageVo.setStudentTwoVo(null);
			classMessageVo.setTeacher(null);
		}else {
			classMessageVo.setError(1);
			classMessageVo.setErrorMessage("成功返回班级信息");
			classMessageVo.setOneClass(studentClassService.findClassByClassId(classId));
			classMessageVo.setTeacher(studentClassService.findTeacherByclassId(classId));
			classMessageVo.setStudentTwoVo(studentClassService.findStudentTwoVoByClassId(classId));
		}
		return classMessageVo;
	}
	
	//退出班级
	@RequestMapping(value = "/quitClass", method = RequestMethod.GET)
	public @ResponseBody BaseVo quitClass(int classId, int stuId) {
		BaseVo baseVo = new BaseVo();
		if(studentClassService.IfClassStudentExist(stuId, classId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("学生和班级不存在");
		}else {
			baseVo.setError(1);
			baseVo.setErrorMessage("成功退出班级");
			studentClassService.StudentQuitClass(stuId, classId);
		}
		return baseVo;
	}
}
