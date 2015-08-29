package com.startup.service;

import java.util.List;

import com.startup.pojo.Class;
import com.startup.pojo.ItemTest;
import com.startup.pojo.Student;
import com.startup.pojo.Teacher;
import com.startup.vo.StudentTwoVo;
import com.startup.vo.StudentVo;

public interface StudentClassService {

	//通过学生id查找学生对应班级号
	public int selectClassIdByStudentId(int studentId);
   
	//通过班级号查找题组内容以及激活状态
	public List<ItemTest> selectItemTestByClassId(int classId, int stuId);
	
	//查找班级号是否存在
	public int IfClassIdExist(int classId);
	
	//学生加入新班级，插入班级-学生表
	public int StudentAddClass(int classId , int stuId);

	//判断学生id是否存在
	public int IfStuIdExist(int stuId);

	//判断学生和班级，避免重复插入数据
	public int IfClassStudentExist(int stuId, int classId);

	public int findClassIdByClassNo(int classNo);

	public Class findClassByClassId(int classId);

	public Teacher findTeacherByclassId(int classId);

	public List<StudentTwoVo> findStudentTwoVoByClassId(int classId);

	public int StudentQuitClass(int stuId, int classId);

	public int UpdateStudentPhoto(String uploadImagePath, int id);

	
}
