package com.startup.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.StudentClassService;
import com.startup.service.TeacherClassService;
import com.startup.vo.BaseVo;
import com.startup.vo.ClassTwoVo;
import com.startup.vo.ClassVo;
import com.startup.vo.CreateClassVo;
import com.startup.vo.IntVo;
import com.startup.pojo.Class;
/**
 * 
 * @author LiuFeng
 *
 */
@Controller
@RequestMapping("/teacher/class")
public class TeacherClassController {
	@Resource
	private TeacherClassService teacherClassService;
	
	@Resource
	private StudentClassService studentClassService;
	
	@RequestMapping(value = "/getClass", method = RequestMethod.GET)
	public @ResponseBody ClassVo getClass(int teacherId) {
		ClassVo classVo = new ClassVo();
		if(teacherClassService.IfTeacherIdExist(teacherId) == 0) {
			classVo.setError(0);
			classVo.setErrorMessage("没有这个老师");
			classVo.setOneclass(null);
		}else {
			if(teacherClassService.findClassByTeacherId(teacherId).size() == 0) {
				classVo.setError(1);
				classVo.setErrorMessage("老师还没有班级");
				classVo.setOneclass(null);
			}else {
				classVo.setError(2);
				classVo.setErrorMessage("成功返回老师的班级");
				classVo.setOneclass(teacherClassService.findClassByTeacherId(teacherId));
			}
		}
		return classVo;
	}
	
	@RequestMapping(value = "/createClass", method = RequestMethod.POST)
	public @ResponseBody IntVo createClass(@RequestBody CreateClassVo createClassVo) {
		IntVo intVo = new IntVo();
		int teacherId = createClassVo.getTeacherId();
		if(teacherClassService.IfTeacherIdExist(teacherId) == 0) {
			intVo.setError(0);
			intVo.setErrorMessage("没有这个老师");
			intVo.setNumber(0);
		}else {
			int result = teacherClassService.createClass(createClassVo);
			intVo.setError(1);
			intVo.setErrorMessage("成功创建班级");
			intVo.setNumber(result);
		}
		return intVo;
	}
	
	@RequestMapping(value = "/changeClassMessage", method = RequestMethod.POST)
	public @ResponseBody BaseVo changeClassMessage(@RequestBody ClassTwoVo classTwoVo) {
		BaseVo baseVo = new BaseVo();
		int classId = classTwoVo.getClassId();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这个班级");
		}else {
			teacherClassService.changeClassMessage(classTwoVo);
			baseVo.setError(1);
			baseVo.setErrorMessage("成功设置班级信息");
		}
		return baseVo;
	}
}
