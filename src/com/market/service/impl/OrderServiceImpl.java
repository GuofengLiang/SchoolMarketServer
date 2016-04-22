package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.OrderDao;
import com.market.entity.Order;
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
	@Override
	public List<Order> findAllOrders(int userId) {
		List<Order> orders = orderDao.findAllOrders(userId);
		return orders;
	}
}
