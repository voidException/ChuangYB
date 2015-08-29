package com.startup.dao;

import java.util.List;

import com.startup.pojo.ItemTest;

public interface ItemTestMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(ItemTest record);

    int insertSelective(ItemTest record);

    ItemTest selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(ItemTest record);

    int updateByPrimaryKey(ItemTest record);

	List<ItemTest> selectAllItem();
}