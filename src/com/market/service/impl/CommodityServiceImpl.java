package com.market.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.CommodityDao;
import com.market.dao.SupermarketDao;
import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;
import com.market.service.CommodityService;
@Service
public class CommodityServiceImpl implements CommodityService {
	@Resource(name="commodityDaoImpl")
    public CommodityDao commodityDao;

	@Override
	public Commodity findSingleComm(int commodityId) {

		Commodity commodity=commodityDao.findSingleComm(commodityId);
		return commodity;
	}

}
