package com.market.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.OrderDao;
import com.market.entity.Address;
import com.market.entity.Order;
import com.market.entity.User;
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
		Query query = entityManager.createQuery("select s from Order s where s.user.userId=?1");
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
	/**
	 * 添加单个订单
	 */
	@Override
	@Transactional
	public void addSingleOrder(int addressId, int userId, int state, Date orderTime,
			Date deliverTime, float freight, float total, String remarks) {
		//通过addressId获取地址
		Query query1 = entityManager.createQuery("select a from Address a where a.addressId=:addressId");
		//通过userId获取用户
		Query query2 = entityManager.createQuery("select u from User u where u.userId=:userId");
		query1.setParameter("addressId", addressId);
		Address address = (Address) query1.getSingleResult();
		query2.setParameter("userId", userId);
		User user = (User) query2.getSingleResult();
		//持久化order
		Order order = new Order();
		order.setAddressId(address);
		order.setUser(user);
		order.setDeliverTime(deliverTime);
		order.setFreight(freight);
		order.setOrderTime(orderTime);
		order.setRemarks(remarks);
		order.setState(state);
		order.setTotal(total);
		entityManager.persist(order);
		
	}
}
