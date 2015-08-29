package com.startup.vo;

import java.util.List;

public class StudentGradeVo extends BaseVo{
	List<StudentThreeVo> studentThreeVo;

	public List<StudentThreeVo> getStudentThreeVo() {
		return studentThreeVo;
	}

	public void setStudentThreeVo(List<StudentThreeVo> studentThreeVo) {
		this.studentThreeVo = studentThreeVo;
	}
	
}
