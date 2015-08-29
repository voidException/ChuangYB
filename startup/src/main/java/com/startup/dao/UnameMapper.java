package com.startup.dao;

import java.util.List;
import java.util.Map;

import com.startup.pojo.Uname;

public interface UnameMapper {
    int deleteByPrimaryKey(Integer unameid);

    int insert(Uname record);

    int insertSelective(Uname record);

    Uname selectByPrimaryKey(Integer unameid);

    int updateByPrimaryKeySelective(Uname record);

    int updateByPrimaryKey(Uname record);

	List<Uname> selectByClassId(int classId);

	int deleteByClassItemId(Map<String, Integer> params);

	Uname selectByClassItemId(Map<String, Integer> params);
}