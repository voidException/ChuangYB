package com.startup.dao;

import java.util.List;

import com.startup.pojo.ItemToTest;

public interface ItemToTestMapper {
    int deleteByPrimaryKey(Integer itemtotestid);

    int insert(ItemToTest record);

    int insertSelective(ItemToTest record);

    ItemToTest selectByPrimaryKey(Integer itemtotestid);

    int updateByPrimaryKeySelective(ItemToTest record);

    int updateByPrimaryKey(ItemToTest record);

	List<ItemToTest> selectByItemId(int itemId);
}