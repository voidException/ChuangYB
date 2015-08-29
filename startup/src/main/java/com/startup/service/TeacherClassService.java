package com.startup.service;

import java.util.List;

import com.startup.pojo.Class;
import com.startup.pojo.ItemTest;
import com.startup.vo.ClassTwoVo;
import com.startup.vo.CreateClassVo;
import com.startup.vo.ItemAccurateNumVo;
import com.startup.vo.StudentThreeVo;
import com.startup.vo.TeacherItemTwoVo;

public interface TeacherClassService {

	int IfTeacherIdExist(int teacherId);

	List<Class> findClassByTeacherId(int teacherId);

	int createClass(CreateClassVo createClassVo);

	int changeClassMessage(ClassTwoVo classTwoVo);

	List<ItemTest> selectItemTestByClassId(int classId);

	int addItemToClass(int classId, int itemId);

	int deleteItemFromClass(int classId, int itemId);

	int updateItemFromClass(TeacherItemTwoVo teacherItemTwoVo);

	List<ItemTest> getAllItem();

	List<ItemAccurateNumVo> CalculateItemAccuracy(int classId, int itemId);

	List<StudentThreeVo> CalculateStudentGrade(int classId);

	int IfClassItemExist(int classId, int itemId);

	int UpdateTeacherPhoto(String uploadImagePath, int id);

}
