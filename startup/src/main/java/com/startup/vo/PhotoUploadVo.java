package com.startup.vo;

import java.io.File;

public class PhotoUploadVo {
	private File fileData;
	//0代表学生，1代表老师
	private int isStudentOrTeacher;
	private int Id;
	private String form = ".jpg";
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public File getFileData() {
		return fileData;
	}
	public void setFileData(File fileData) {
		this.fileData = fileData;
	}
	public int getIsStudentOrTeacher() {
		return isStudentOrTeacher;
	}
	public void setIsStudentOrTeacher(int isStudentOrTeacher) {
		this.isStudentOrTeacher = isStudentOrTeacher;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
}
