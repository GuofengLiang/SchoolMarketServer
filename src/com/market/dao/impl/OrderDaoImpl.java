package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.AddressDao;
import com.market.dao.OrderDao;
import com.market.entity.Address;
import com.market.entity.Commodity;
import com.market.entity.Order;
import com.market.entity.OrderItem;
import com.market.entity.User;
import com.market.javabean.AddressBean;
import com.market.javabean.BuyCommBean;
import com.market.javabean.OrderBean;
import com.market.javabean.OrderCommBean;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Resource(name = "addressDaoImpl")
	public AddressDao addressDao;
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
			AddressBean addressBean =  addressDao.findSingleAddress(list.get(i).getAddressId().getAddressId());
			orderbean.setAddressBean(addressBean);
			listbean.add(orderbean);
		}
		return listbean;
	}
	/**
	 * 添加单个订单
	 
	@Override
	@Transactional
	public void addSingleOrder(int addressId, int userId, int state, Date orderTime,
			Date deliverTime, float freight, float total, String remarks, int commodityId, int commNumber) {
		//通过addressId获取地址
		Query query1 = entityManager.createQuery("select a from Address a where a.addressId=:addressId");
		//通过userId获取用户
		Query query2 = entityManager.createQuery("select u from User u where u.userId=:userId");
		//通过commodityId获取商品
		Query query3 = entityManager.createQuery("select c from Commodity c where c.commodityId=:commodityId");
		query1.setParameter("addressId", addressId);
		query2.setParameter("userId", userId);
		query3.setParameter("commodityId", commodityId);
		
 		Address address = (Address) query1.getSingleResult();
		
		User user = (User) query2.getSingleResult();
		
		Commodity commodity = (Commodity) query3.getSingleResult();
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
		//持久化orderItem
		OrderItem orderItem = new OrderItem();
		orderItem.setCommodity(commodity);
		orderItem.setOrder(order);
		orderItem.setCommNumber(commNumber);
		entityManager.persist(orderItem);
		
	}*/
	/**
	 * 添加一个订单
	 */
	@Transactional
	@Override
	public void addOrder(BuyCommBean buyCommBean) {
		//通过addressId获取地址
				Query query1 = entityManager.createQuery("select a from Address a where a.addressId=:addressId");
				//通过userId获取用户
				Query query2 = entityManager.createQuery("select u from User u where u.userId=:userId");
				
				query1.setParameter("addressId", buyCommBean.getAddressId());
				query2.setParameter("userId", buyCommBean.getUserId());

				
		 		Address address = (Address) query1.getSingleResult();
				
				User user = (User) query2.getSingleResult();
				//持久化order
				Order order = new Order();
				order.setAddressId(address);
				order.setUser(user);
				order.setDeliverTime(buyCommBean.getDeliverTime());
				order.setFreight(buyCommBean.getFreight());
				order.setOrderTime(buyCommBean.getOrderTime());
				order.setRemarks(buyCommBean.getRemarks());
				//order.setState(buyCommBean.sta);
				order.setTotal(buyCommBean.getTotal());
				entityManager.persist(order);
				//持久化orderItem
				for(int i = 0; i<buyCommBean.getCommListBeans().size(); i++) {
					//通过commodityId获取商品
					Query query3 = entityManager.createQuery("select c from Commodity c where c.commodityId=:commodityId");
					query3.setParameter("commodityId", buyCommBean.getCommListBeans().get(i).getCommodityId());
					Commodity commodity = (Commodity) query3.getSingleResult();
					OrderItem orderItem = new OrderItem();
					orderItem.setCommodity(commodity);
					orderItem.setOrder(order);
					orderItem.setCommNumber(buyCommBean.getCommListBeans().get(i).getCommNumber());
					entityManager.persist(orderItem);
				}
	}
	/**
	 * 根据订单id查找订单商品和数量
	 */
	@Override
	public List<OrderCommBean> findAllOrderComm(int orderId) {
		Query query = entityManager.createQuery("select o from OrderItem o where o.order.orderId=?1");
		query.setParameter(1, orderId);
		@SuppressWarnings("unchecked")
		List<OrderItem> orderItemList = query.getResultList();
		List<OrderCommBean> orderCommBeanList = new ArrayList<OrderCommBean>();
		for(int i = 0; i<orderItemList.size(); i++) {
			OrderCommBean orderCommBean = new OrderCommBean();
			orderCommBean.setCommodityId(orderItemList.get(i).getCommodity().getCommodityId());
			orderCommBean.setCommName(orderItemList.get(i).getCommodity().getCommName());
			orderCommBean.setDescribes(orderItemList.get(i).getCommodity().getDescribes());
			orderCommBean.setDiscount(orderItemList.get(i).getCommodity().getDiscount());
			orderCommBean.setMainclassId(orderItemList.get(i).getCommodity().getMainclassId().getMainclassId());
			orderCommBean.setMainclassName(orderItemList.get(i).getCommodity().getMainclassId().getMainclassName());
			orderCommBean.setSubclassId(orderItemList.get(i).getCommodity().getSubclassId().getSubclassId());
			orderCommBean.setSubclassName(orderItemList.get(i).getCommodity().getSubclassId().getSubclassName());
			orderCommBean.setPicture(orderItemList.get(i).getCommodity().getPicture());
			orderCommBean.setPrice(orderItemList.get(i).getCommodity().getPrice());
			orderCommBean.setSales(orderItemList.get(i).getCommodity().getSales());
			orderCommBean.setSpecialTime(orderItemList.get(i).getCommodity().getSpecialTime());
			orderCommBean.setSpercification(orderItemList.get(i).getCommodity().getSpercification());
			orderCommBean.setStock(orderItemList.get(i).getCommodity().getStock());
			orderCommBean.setType(orderItemList.get(i).getCommodity().getType());
			orderCommBean.setOrderNumber(orderItemList.get(i).getCommNumber());
			orderCommBeanList.add(orderCommBean);
		}
		return orderCommBeanList;
	}
}
