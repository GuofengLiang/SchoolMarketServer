package com.market.dao;

import com.market.entity.Commodity;

public interface CommodityDao {

	 /**
	   * 通过商品id来获取该商品表该id的商品
	   * @param commodityId
	   * @return
	   */
	Commodity findSingleComm(int commodityId);
}
