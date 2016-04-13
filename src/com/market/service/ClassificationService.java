package com.market.service;

import java.util.List;

import com.market.entity.Classification;
import com.market.entity.Commodity;

public interface ClassificationService {

	/**
	 * 通过分类id来查找所有该分类的商品
	 * @param classId
	 * @return
	 */
	List<Commodity> findAllCommodity(int classId);
	/**
	 * 通过分类id来查找该分类的相关信息
	 * @param classId
	 * @return
	 */
	Classification findSingleClass(int classId);
}
