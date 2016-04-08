package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.SupermarketDao;
import com.market.entity.Commodity;
import com.market.service.SupermarketService;
@Service
public class SupermarketServiceImpl implements SupermarketService {
    @Resource(name="supermarketDaoImpl")
    public SupermarketDao supermarketDao;
    
	@Override
	public List<Commodity> findAllCommodity(int supermarketId) {
		List<Commodity> commodities=supermarketDao.findAllCommodity(supermarketId);
		return commodities;
	}

}
