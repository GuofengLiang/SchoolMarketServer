package com.market.service;

import java.util.List;

import com.market.entity.MainClassify;

public interface MainClassifyService {

	/**
	 * 查找所有mainclassify的数据
	 * @return
	 */
	List<MainClassify> findAllMainClassify();
	/**
<<<<<<< HEAD
	 * 根据mainclassId删除mainclass和subclass
	 * @param mainclassId
	 */
	void delectClassify(int mainclassId);
     /**
	 * 添加主分类
	 */
	void addMainClassify(String mainclassName) throws Exception;
	/**
	 * 修改主分类
	 */
	void alterMainClassify(int mainclassId, String mainclassName) throws Exception;
	/**
	 * 根据mainclassId来查询该主分类的信息
	 */
	MainClassify findSingleMainClassify(int mainclassId);
}
