package com.market.dao;

import java.util.List;

import com.market.entity.MainClassify;

public interface MainClassifyDao {

	/**
	 * 查找所有mainclassify的数据
	 * @return
	 */
	List<MainClassify> findAllMainClassify();
	/**
	 * 根据mainclassId删除mainclass和subclass
	 * @param mainclassId
	 */
	void delectClassify(int mainclassId);
}
