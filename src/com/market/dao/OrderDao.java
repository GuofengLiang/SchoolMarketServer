package com.market.dao;

import java.util.List;

import com.market.entity.Order;

public interface OrderDao {

	/**
	 * 根据订单id来查找订单相关信息
	 * 
	 * @author logolin
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
