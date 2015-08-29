package com.startup.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.StudentClassService;
import com.startup.service.StudentTestService;
import com.startup.service.TeacherClassService;
import com.startup.vo.BaseVo;
import com.startup.vo.ItemAccuracyVo;
import com.startup.vo.StudentGradeVo;
import com.startup.vo.StudentItemVo;
import com.startup.vo.TeacherItemTwoVo;
import com.startup.vo.TeacherItemVo;

/**
 * 
 * @author LiuFeng
 *
 */
@Controller
@RequestMapping("/teacher/test")
public class TeacherTestController {
	@Resource
	TeacherClassService teacherClassService;
	
	@Resource
	StudentClassService studentClassService;
	
	@Resource
	StudentTestService studentTestService;
	
	@RequestMapping(value = "/getItem", method = RequestMethod.GET)
	public @ResponseBody TeacherItemVo getItem(int classId) {
		TeacherItemVo teacherItemVo = new TeacherItemVo();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			teacherItemVo.setError(0);
			teacherItemVo.setErrorMessage("没有这个班级");
			teacherItemVo.setItemTest(null);
		}else {
			teacherItemVo.setError(1);
			teacherItemVo.setErrorMessage("成功返回班级题组");
			teacherItemVo.setItemTest(teacherClassService.selectItemTestByClassId(classId));
		}
		return teacherItemVo;
	}
	
	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public @ResponseBody BaseVo addItem(int classId, int itemId) {
		BaseVo baseVo = new BaseVo();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这个班级");
		}else {
			if(studentTestService.ifItemExist(itemId) == 0){
				baseVo.setError(1);
				baseVo.setErrorMessage("没有这个题组");
			}else {
				if(teacherClassService.IfClassItemExist(classId, itemId) == 0) {
					teacherClassService.addItemToClass(classId, itemId);
					baseVo.setError(3);
					baseVo.setErrorMessage("成功插入1条题组");
				}else {
					baseVo.setError(2);
					baseVo.setErrorMessage("题组已经存在班级里了");
				}
			}
		}
		return baseVo;
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public @ResponseBody BaseVo deleteItem(int classId, int itemId) {
		BaseVo baseVo = new BaseVo();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这个班级");
		}else {
			if(studentTestService.ifItemExist(itemId) == 0){
				baseVo.setError(1);
				baseVo.setErrorMessage("没有这个题组");
			}else {
				if(teacherClassService.IfClassItemExist(classId, itemId) == 0) {
					baseVo.setError(2);
					baseVo.setErrorMessage("班级里没有这个题组");
				}else {
					baseVo.setError(3);
					baseVo.setErrorMessage("成功删除题组");
					teacherClassService.deleteItemFromClass(classId, itemId);
				}
			}
		}
		return baseVo;
	}
	
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public @ResponseBody BaseVo updateItem(@RequestBody TeacherItemTwoVo teacherItemTwoVo) {
		BaseVo baseVo = new BaseVo();
		int classId = teacherItemTwoVo.getClassId();
		int itemId = teacherItemTwoVo.getItemId();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			baseVo.setError(0);
			baseVo.setErrorMessage("没有这个班级");
		}else {
			if(studentTestService.ifItemExist(itemId) == 0){
				baseVo.setError(1);
				baseVo.setErrorMessage("没有这个题组");
			}else {
				if(teacherClassService.IfClassItemExist(classId, itemId) == 0) {
					baseVo.setError(2);
					baseVo.setErrorMessage("班级里没有这个题组");
				}else {
					teacherClassService.updateItemFromClass(teacherItemTwoVo);
					baseVo.setError(3);
					baseVo.setErrorMessage("已经成功更改激活状态");
				}
			}
		}
		return baseVo;
	}
	
	@RequestMapping(value = "/getAllItem", method = RequestMethod.GET)
	public @ResponseBody TeacherItemVo getAllItem(int teacherId) {
		TeacherItemVo teacherItemVo = new TeacherItemVo();
		if(teacherClassService.IfTeacherIdExist(teacherId) == 0) {
			teacherItemVo.setError(0);
			teacherItemVo.setErrorMessage("没有这个老师");
			teacherItemVo.setItemTest(null);
		}else {
			teacherItemVo.setError(1);
			teacherItemVo.setErrorMessage("成功返回所有题组");
			teacherItemVo.setItemTest(teacherClassService.getAllItem());
		}
		return teacherItemVo;
	}
	
	@RequestMapping(value = "/getItemAccuracy", method = RequestMethod.GET)
	public @ResponseBody ItemAccuracyVo getItemAccuracy(int classId, int itemId) {
		ItemAccuracyVo itemAccuracyVo = new ItemAccuracyVo();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			itemAccuracyVo.setError(0);
			itemAccuracyVo.setErrorMessage("班级不存在");
			itemAccuracyVo.setItemAccurateNumVo(null);
		}else {
			if(studentTestService.ifItemExist(itemId) == 0){
				itemAccuracyVo.setError(1);
				itemAccuracyVo.setErrorMessage("题组不存在");
				itemAccuracyVo.setItemAccurateNumVo(null);
			}else {
				if(teacherClassService.IfClassItemExist(classId, itemId) == 0) {
					itemAccuracyVo.setError(2);
					itemAccuracyVo.setErrorMessage("班级题组不存在");
					itemAccuracyVo.setItemAccurateNumVo(null);
				}else {
					itemAccuracyVo.setError(3);
					itemAccuracyVo.setErrorMessage("成功返回题组正确率");
					itemAccuracyVo.setItemAccurateNumVo(teacherClassService.CalculateItemAccuracy(classId, itemId));
				}
			}
		}
		return itemAccuracyVo;
	}
	
	@RequestMapping(value = "/getStudentGrade", method = RequestMethod.GET)
	public @ResponseBody StudentGradeVo getStudentGrade(int classId) {
		StudentGradeVo studentGradeVo = new StudentGradeVo();
		if(studentClassService.IfClassIdExist(classId) == 0) {
			studentGradeVo.setError(0);
			studentGradeVo.setErrorMessage("班级不存在");
			studentGradeVo.setStudentThreeVo(null);
		}else {
			studentGradeVo.setError(1);
			studentGradeVo.setErrorMessage("成功返回学生");
			studentGradeVo.setStudentThreeVo(teacherClassService.CalculateStudentGrade(classId));
		}
		return studentGradeVo;
	}
}
