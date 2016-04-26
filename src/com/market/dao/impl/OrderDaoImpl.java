package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.OrderDao;
import com.market.entity.Order;
import com.market.javabean.OrderBean;

@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;
	//通过orderId查找订单
	@Override
	public Order findSingleOrder(int orderId) {

		Query query = entityManager.createQuery("select s from Order s where s.orderId=?1");
		query.setParameter(1, orderId);
		Order order = (Order) query.getSingleResult();
		return order;
	}
	//根据userId查找订单
	@Override
	public List<OrderBean> findAllOrders(int userId) {
		Query query = entityManager.createQuery("select s from Orders s where s.user.userId=?1");
		query.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<Order> list = query.getResultList();
		List<OrderBean> listbean = new ArrayList<OrderBean>();
		for(int i=0; i<list.size(); i++) {
			OrderBean orderbean = new OrderBean();
			orderbean.setOrderId(list.get(i).getOrderId());
			orderbean.setState(list.get(i).getState());
			orderbean.setOrderTime(list.get(i).getOrderTime());
			orderbean.setDeliverTime(list.get(i).getDeliverTime());
			orderbean.setFreight(list.get(i).getFreight());
			orderbean.setTotal(list.get(i).getTotal());
			orderbean.setRemarks(list.get(i).getRemarks());
			listbean.add(orderbean);
		}
		return listbean;
	}
}
