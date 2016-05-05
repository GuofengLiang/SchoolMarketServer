package com.market.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.OrderDao;
import com.market.entity.Order;
import com.market.javabean.BuyCommBean;
import com.market.javabean.OrderBean;
import com.market.javabean.OrderCommBean;
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
	 
	@Override
	public void addSingleOrder(int addressId, int userId, int state, Date orderTime, Date deliverTime, float freight,
			float total, String remarks, int commodityId, int commNumber) {
		orderDao.addSingleOrder(addressId, userId, state, orderTime, deliverTime, freight, total, remarks, commodityId, commNumber);
		
	}
	*/
	
	@Override
	public List<OrderCommBean> findAllOrderComm(int orderId) {
		List<OrderCommBean> orderCommBeanList = orderDao.findAllOrderComm(orderId);
		return orderCommBeanList;
	}
	@Override
	public void addOrder(BuyCommBean buyCommBean) {
		orderDao.addOrder(buyCommBean);
	}
}
