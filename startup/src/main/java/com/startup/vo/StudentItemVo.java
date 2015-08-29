package com.startup.vo;

import java.util.List;

import com.startup.pojo.ItemTest;
/**
 * 返回班级号，班级题组及题组是否激活
 * @author LiuFeng
 *
 */
public class StudentItemVo extends BaseVo{

	int classId = 0;//返回每个学生对应的班级号
	List<ItemTest> itemTest;//返回每个班级对应的题组以及题组的状态是否激活
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public List<ItemTest> getItemTest() {
		return itemTest;
	}
	public void setItemTest(List<ItemTest> itemTest) {
		this.itemTest = itemTest;
	}
	
	
	
}
