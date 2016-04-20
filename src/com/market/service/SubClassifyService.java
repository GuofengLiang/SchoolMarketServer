package com.market.service;

import java.util.List;

import com.market.entity.SubClassify;

public interface SubClassifyService {

	/**
	 * 根据mainclassId获取大分类的子类
	 * @param mainclassId
	 * @return
	 */
   List<SubClassify> findAllSubClassify(int mainclassId);
}
