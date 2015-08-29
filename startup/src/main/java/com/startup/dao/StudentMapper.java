package com.startup.dao;

import java.util.List;

import com.startup.pojo.Student;
import com.startup.util.Paging;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuid);
    
    Student selectByStudentEmail(String email);//根据学生用户的邮箱查找学生的记录，实现是在xml配置里，最终由mybatis实现的

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectStudentsEmail(Paging paging);
}