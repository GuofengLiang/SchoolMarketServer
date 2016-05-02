package com.market.service;

import java.util.Date;
import java.util.List;

import com.market.entity.Order;
import com.market.javabean.OrderBean;

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
	List<OrderBean> findAllOrders(int userId);
	/**
	 * 添加单个订单
	 * @param addressId
	 * @param userId
	 * @param state
	 * @param defaultedAddress
	 * @param orderTime
	 * @param deliverTime
	 * @param freight
	 * @param total
	 * @param remarks
	 */
	void addSingleOrder(int addressId, int userId, int state, Date orderTime,
			Date deliverTime, float freight, float total, String remarks);
}
