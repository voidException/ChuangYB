package com.startup.pojo;

public class University {
    private Integer universityid;

    private String universityno;

    private String universityname;

    public Integer getUniversityid() {
        return universityid;
    }

    public void setUniversityid(Integer universityid) {
        this.universityid = universityid;
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
}