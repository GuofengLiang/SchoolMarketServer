package com.market.dao;

import java.util.List;

import com.market.entity.ShopCart;

public interface ShopCartDao {

	/**
	 * 通过用户id查找购物车详情
	 * @param userId
	 * @ return
	 */
	List<ShopCart> findAllShopCarts(int userId);
}
