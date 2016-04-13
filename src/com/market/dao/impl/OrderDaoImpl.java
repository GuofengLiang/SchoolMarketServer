package com.market.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.OrderDao;
import com.market.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public Order findSingleOrder(int orderId) {
		
		Query query = entityManager.createQuery("select o from Order o where o.orderId=?1");
		query.setParameter(1, orderId);
		Order order = (Order) query.getSingleResult();
		return order;
	}

}
