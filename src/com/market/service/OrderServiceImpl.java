package com.market.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.OrderDao;
import com.market.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource(name="OrderDaoImpl")
	public OrderDao orderDao;

	@Override
	public Order findSingleOrder(int orderId) {
		
		Order order = orderDao.findSingleOrder(orderId);
		return order;
	}

}
