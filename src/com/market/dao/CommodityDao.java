package com.market.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;

public interface CommodityDao {

	/**
	 * 通过商品id来获取该商品表该id的商品
	 * 
	 * @param commodityId
	 * @return
	 */
	CommodityBean findSingleComm(int commodityId);

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
	List<CommodityBean> findAllCommByType(String type);
	/**
	 * 根据超市id和主分类id查找商品
	 * @param supermartketId
	 * @param mainclassId
	 * @return
	 */
	List<Commodity> findAllCommByMclass(int supermartketId, int mainclassId);
	/**
	 * 根据主分类id来查找该分类下的所有商品
	 * @param mainclassId
	 * @return
	 */
	List<CommodityBean> findAllCommByMainId(int mainclassId);
	/**
	 * 查找热卖商品
	 * 按照sales来查找销量前六的商品
	 * @param sales
	 * @return
	 */
	List<CommodityBean> findSixCommBySales();
	/**
	 * 只显示6个最新推荐商品
	 * 查找推荐商品
	 * @return
	 */
	List<CommodityBean> findSixCommByRecomoend();
	/**
	 * 查找推荐商品和热卖商品
	 * @return
	 */
	List<Map<String,Object>> findSaleAndSpecialComm();
	/**
	 * 根据商品名模糊查找商品
	 */
	List<Commodity> fuzzySearchComm();
}
