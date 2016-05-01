package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.SupermarketDao;
import com.market.entity.Commodity;
import com.market.javabean.AdvertiseBean;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;
import com.market.service.SupermarketService;

@Service
public class SupermarketServiceImpl implements SupermarketService {
	@Resource(name = "supermarketDaoImpl")
	public SupermarketDao supermarketDao;

	/**
	 * 根据超市id查找所有商品
	 */
	@Override
	public List<CommodityBean> findAllCommodity(int supermarketId) {
		List<CommodityBean> commodities = supermarketDao.findAllCommodity(supermarketId);
		return commodities;
	}

	/**
	 * 根据超市id查找超市信息
	 */
	@Override
	public SupermarketBean findSingleSuper(int supermarketId) {
		SupermarketBean supermarketBean = supermarketDao
				.findSingleSuper(supermarketId);
		return supermarketBean;
	}

	/**
	 * 根据超市id查找所有广告信息
	 */
	@Override
	public List<AdvertiseBean> findAllAdvertises(int supermarketId) {
		List<AdvertiseBean> advertiseListBean = supermarketDao.findAllAdvertises(supermarketId);
		return advertiseListBean;
	}

}
