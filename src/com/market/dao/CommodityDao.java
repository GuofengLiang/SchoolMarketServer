package com.market.dao;

import java.util.Date;
import java.util.List;

import com.market.entity.Commodity;

public interface CommodityDao {

	/**
	 * 通过商品id来获取该商品表该id的商品
	 * 
	 * @param commodityId
	 * @return
	 */
	Commodity findSingleComm(int commodityId);

	/**
	 * 添加单个商品
	 * 
	 * @param mainclassName
	 * @param subclassName
	 * @param commName
	 * @param picture
	 * @param price
	 * @param spercification
	 * @param describes
	 * @param stock
	 * @param discount
	 * @param specialTime
	 * @param type
	 */
	void addSingleCommodity(int mainclassId, int subclassId,
			String commName, String picture,
			float price,
			String spercification,// 规格，重量
			String describes, int stock, float discount, Date specialTime,
			String type, int supermarketId);
	/**
	 * 根据商品类型type来查找商品
	 * @param type
	 * @return
	 */
	List<Commodity> findAllCommByType(String type);
}
