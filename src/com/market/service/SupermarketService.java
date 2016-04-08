package com.market.service;

import java.util.List;

import com.market.entity.Commodity;

public interface SupermarketService {
	/**
	 * 通过超市id来获取该超市的所有商品
	 * @param supermarketId
	 * @return
	 */
	List<Commodity> findAllCommodity(int supermarketId);
}
