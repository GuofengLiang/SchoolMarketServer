package com.market.service;

import java.util.List;

import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;

public interface SupermarketService {
	/**
	 * 通过超市id来获取该超市的所有商品
	 * 
	 * @param supermarketId
	 * @return
	 */
	List<CommodityBean> findAllCommodity(int supermarketId);

	/**
	 * 根据supermarketId来查询该超市的相关信息
	 * 
	 * @param supermarketId
	 * @return
	 */
	SupermarketBean findSingleSuper(int supermarketId);
}
