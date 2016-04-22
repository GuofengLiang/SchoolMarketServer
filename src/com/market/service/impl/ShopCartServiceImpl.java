package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.ShopCartDao;
import com.market.entity.ShopCart;
import com.market.entity.User;
import com.market.service.ShopCartService;

@Service
public class ShopCartServiceImpl implements ShopCartService {
	@Resource(name = "shopCartDaoImpl")
	public ShopCartDao shopCartDao;

	/**
	 * 通过用户id查找购物车详情
	 * @param userId
	 * @ return
	 */
	@Override
	public List<ShopCart> findAllShopCarts(int userId) {
		List<ShopCart> shopCarts = shopCartDao.findAllShopCarts(userId);
		return shopCarts;
	}

}
