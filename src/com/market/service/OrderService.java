package com.market.service;

import com.market.entity.Order;

public interface OrderService {

	/**
	 * @author logolin 通过分类id来查找该分类的相关信息
	 * @param orderId
	 * @return
	 */
	Order findSingleOrder(int orderId);
}
