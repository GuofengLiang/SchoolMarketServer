package com.market.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.ShopCartDao;
import com.market.entity.ShopCart;
import com.market.entity.User;

@Repository
public class ShopCartDaoImpl implements ShopCartDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 通过用户id查找购物车详情
	 * @param userId
	 * @ return
	 */
	@Override
	public List<ShopCart> findAllShopCarts(int userId) {
		Query query = entityManager.createQuery("select s from ShopCart s where s.user.userId=?1");
		query.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<ShopCart> shopCarts = query.getResultList();
		return shopCarts;
	}

}
