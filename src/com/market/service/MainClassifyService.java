package com.market.service;

import java.util.List;

import com.market.entity.MainClassify;

public interface MainClassifyService {

	/*
	 * 查找所有mainclassify的数据
	 * @return
	 */
	List<MainClassify> findAllMainClassify();
}
