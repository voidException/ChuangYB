package com.startup.pojo;

public class Teacher {
    private Integer teacherid;

    private String teachername;

    private String universityno;

    private String universityname;

    private String nickuniversityname;

    private String email;

    private String passwords;

    private String tel;

    private String photo;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
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

    public String getNickuniversityname() {
        return nickuniversityname;
    }

    public void setNickuniversityname(String nickuniversityname) {
        this.nickuniversityname = nickuniversityname == null ? null : nickuniversityname.trim();
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}