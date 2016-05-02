package com.market.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.OrderDao;
import com.market.entity.Order;
import com.market.javabean.OrderBean;
import com.market.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource(name = "orderDaoImpl")
	public OrderDao orderDao;

	@Override
	public Order findSingleOrder(int orderId) {

		Order order = orderDao.findSingleOrder(orderId);
		return order;
	}
	/**
	 * 根据用户id查找订单信息
	 */
	@Override
	public List<OrderBean> findAllOrders(int userId) {
		List<OrderBean> orders = orderDao.findAllOrders(userId);
		return orders;
	}
	/**
	 * 添加单个order
	 */
	@Override
	public void addSingleOrder(int addressId, int userId, int state, Date orderTime, Date deliverTime, float freight,
			float total, String remarks) {
		orderDao.addSingleOrder(addressId, userId, state, orderTime, deliverTime, freight, total, remarks);
		
	}
}
