package com.market.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.entity.Commodity;

public interface CommodityService {

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
	void addSingleCommodity(int mainclassId,int subclassId,
			String commName,
			float price,
			String spercification,// 规格，重量
			String describes, int stock, float discount, Date specialTime,
			String type, int supermarketId, MultipartHttpServletRequest mRequest)
			throws Exception;
	/**
	 * 根据商品类型type来查找商品
	 * @param type
	 * @return
	 */
	List<Commodity> findAllCommByType(String type);
}
