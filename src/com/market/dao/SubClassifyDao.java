package com.market.dao;

import java.util.List;

import com.market.entity.SubClassify;

public interface SubClassifyDao {
	/**
	 * 根据mainclassId获取大分类的子类
	 * @param mainclassId
	 * @return
	 */
   List<SubClassify> findAllSubClassify(int mainclassId);
}
