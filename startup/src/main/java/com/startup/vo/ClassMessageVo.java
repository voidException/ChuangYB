package com.startup.vo;

import java.util.List;

import com.startup.pojo.Class;
import com.startup.pojo.Teacher;

public class ClassMessageVo extends BaseVo {
	private Class oneClass;
	private Teacher teacher;
	private List<StudentTwoVo> studentTwoVo;
	public Class getOneClass() {
		return oneClass;
	}
	public void setOneClass(Class oneClass) {
		this.oneClass = oneClass;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<StudentTwoVo> getStudentTwoVo() {
		return studentTwoVo;
	}
	public void setStudentTwoVo(List<StudentTwoVo> studentTwoVo) {
		this.studentTwoVo = studentTwoVo;
	}
	
}

