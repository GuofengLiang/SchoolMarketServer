package com.market.service;

import java.util.List;

import com.market.entity.Order;

public interface OrderService {

	/**
	 * @author logolin 通过分类id来查找该分类的相关信息
	 * @param orderId
	 * @return
	 */
	Order findSingleOrder(int orderId);
	/*
	 * 根据用户id查找订单
	 * @param userId
	 * @return
	 */
	List<Order> findAllOrders(int userId);
}
