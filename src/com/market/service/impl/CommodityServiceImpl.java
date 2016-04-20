package com.market.service.impl;

import java.util.Date;

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
	public Commodity findSingleComm(int commodityId) {

		Commodity commodity = commodityDao.findSingleComm(commodityId);
		return commodity;
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

}
