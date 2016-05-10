package com.market.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.dao.CommodityDao;
import com.market.dao.SupermarketDao;
import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;
import com.market.service.CommodityService;
import com.market.utils.FileUtils;

@Service
public class CommodityServiceImpl implements CommodityService {
	@Resource(name = "commodityDaoImpl")
	public CommodityDao commodityDao;

	@Override
	public CommodityBean findSingleComm(int commodityId) {

		CommodityBean commodityBean = commodityDao.findSingleComm(commodityId);
		return commodityBean;
	}

	@Override
	public void addSingleCommodity(int mainclassId, int subclassId,
			String commName,float price,
			String spercification, String describes, int stock, float discount,
			Date specialTime, String type, int supermarketId,
			MultipartHttpServletRequest mRequest) throws Exception {
		String picture=FileUtils.upload(mRequest);
		commodityDao.addSingleCommodity(mainclassId, subclassId, commName,
				picture, price, spercification, describes, stock, discount,
				specialTime, type, supermarketId);

	}

	/**
	 * 根据type类型来查找商品
	 */
	@Override
	public List<CommodityBean> findAllCommByType(String type) {
		List<CommodityBean> commType = commodityDao.findAllCommByType(type);
		return commType;
	}
	/**
	 * 根据超市id和主分类id查找商品
	 */
	@Override
	public List<Commodity> findAllCommByMclass(int supermartketId, int mainclassId) {
		List<Commodity> commodityBean = commodityDao.findAllCommByMclass(supermartketId, mainclassId);
		return commodityBean;
	}

	/**
	 * 根据主分类id来查找该分类下的所有商品
	 */
	@Override
	public List<CommodityBean> findAllCommByMainId(int mainclassId) {
		List<CommodityBean> commodityBean = commodityDao.findAllCommByMainId(mainclassId);
		return commodityBean;
	}

	/**
	 * 查找热卖商品
	 * 按照sales来查找销量前六的商品
	 */
	@Override
	public List<CommodityBean> findSixCommBySales() {
		List<CommodityBean> commodityListBean = commodityDao.findSixCommBySales();
		return commodityListBean;
	}

	/**
	 * 查找推荐商品和热卖商品
	 */
	@Override
	public List<Map<String, Object>> findSaleAndSpecialComm() {
		List<Map<String, Object>> commodities = commodityDao.findSaleAndSpecialComm();
		return commodities;
	}

	/**
	 * 根据商品名模糊查找商品
	 */
	@Override
	public List<Commodity> fuzzySearchComm() {
		List<Commodity> commodity = commodityDao.fuzzySearchComm();
		return commodity;
	}

}
