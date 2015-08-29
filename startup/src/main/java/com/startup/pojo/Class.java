package com.startup.pojo;

public class Class {
    private Integer classid;

    private String classroomname;

    private Integer studentnum;

    private Integer realstudentnum;

    private String photo;

    private String universityno;

    private String universityname;

    private Integer classno;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname == null ? null : classroomname.trim();
    }

    public Integer getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(Integer studentnum) {
        this.studentnum = studentnum;
    }

    public Integer getRealstudentnum() {
        return realstudentnum;
    }

    public void setRealstudentnum(Integer realstudentnum) {
        this.realstudentnum = realstudentnum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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

    public Integer getClassno() {
        return classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }
}