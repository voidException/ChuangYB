package com.startup.vo;

public class StudentVo extends BaseVo {
	
	private String stuName ;
	
	private String stuNo;
	
	private String stuPassword;
	
	private String stuPasswordRepeat;
	
	private String stuEmail;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuPasswordRepeat() {
		return stuPasswordRepeat;
	}

	public void setStuPasswordRepeat(String stuPasswordRepeat) {
		this.stuPasswordRepeat = stuPasswordRepeat;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	
}
