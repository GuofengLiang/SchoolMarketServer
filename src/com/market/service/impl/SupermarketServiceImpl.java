package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.SupermarketDao;
import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;
import com.market.service.SupermarketService;

@Service
public class SupermarketServiceImpl implements SupermarketService {
	@Resource(name = "supermarketDaoImpl")
	public SupermarketDao supermarketDao;

	@Override
	public List<CommodityBean> findAllCommodity(int supermarketId) {
		List<CommodityBean> commodities = supermarketDao.findAllCommodity(supermarketId);
		return commodities;
	}

	@Override
	public SupermarketBean findSingleSuper(int supermarketId) {
		SupermarketBean supermarketBean = supermarketDao
				.findSingleSuper(supermarketId);
		return supermarketBean;
	}

}
