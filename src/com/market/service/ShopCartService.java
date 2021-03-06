package com.market.service;

import java.util.List;

import com.market.entity.ShopCart;
import com.market.entity.User;

public interface ShopCartService {

	/**
	 * 通过用户id查找购物车详情
	 * @param userId
	 * @ return
	 */
	List<ShopCart> findAllShopCarts(int userId);
}
