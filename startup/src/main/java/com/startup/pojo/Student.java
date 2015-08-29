package com.startup.pojo;

import java.util.Date;

public class Student {
    private Integer stuid;

    private String stuname;

    private String stuno;

    private String stumajor;

    private String stuschool;

    private String roomno;

    private String department;

    private String college;

    private String universityno;

    private String universityname;

    private Boolean sex;

    private Date incollege;

    private String email;

    private String passwords;

    private String photo;

    private Boolean photoupload;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno == null ? null : stuno.trim();
    }

    public String getStumajor() {
        return stumajor;
    }

    public void setStumajor(String stumajor) {
        this.stumajor = stumajor == null ? null : stumajor.trim();
    }

    public String getStuschool() {
        return stuschool;
    }

    public void setStuschool(String stuschool) {
        this.stuschool = stuschool == null ? null : stuschool.trim();
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno == null ? null : roomno.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getUniversityno() {
        return universityno;
    }

    public void setUniversityno(String universityno) {
        this.universityno = universityno == null ? null : universityno.trim();
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname == null ? null : universityname.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getIncollege() {
        return incollege;
    }

    public void setIncollege(Date incollege) {
        this.incollege = incollege;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords == null ? null : passwords.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Boolean getPhotoupload() {
        return photoupload;
    }

    public void setPhotoupload(Boolean photoupload) {
        this.photoupload = photoupload;
    }

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", stuno="
				+ stuno + ", stumajor=" + stumajor + ", stuschool=" + stuschool
				+ ", roomno=" + roomno + ", department=" + department
				+ ", college=" + college + ", universityno=" + universityno
				+ ", universityname=" + universityname + ", sex=" + sex
				+ ", incollege=" + incollege + ", email=" + email
				+ ", passwords=" + passwords + ", photo=" + photo
				+ ", photoupload=" + photoupload + "]";
	}
    
}