package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.SupermarketDao;
import com.market.entity.Commodity;
import com.market.entity.Supermarket;
import com.market.javabean.SupermarketBean;

@Repository
public class SupermarketDaoImpl implements SupermarketDao {
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Commodity> findAllCommodity(int supermarketId) {
		Query query = entityManager
				.createQuery("select s from Supermarket s where s.supermarketId=?1");
		query.setParameter(1, supermarketId);
		Supermarket supermarket = (Supermarket) query.getSingleResult();
		Set<Commodity> commodities = supermarket.getCommodity();
		List<Commodity> list = new ArrayList<Commodity>(commodities);

		return list;
	}

	@Override
	public SupermarketBean findSingleSuper(int supermarketId) {
		Query query = entityManager
				.createQuery("select s from Supermarket s where s.supermarketId=?1");
		query.setParameter(1, supermarketId);
		Supermarket supermarket = (Supermarket) query.getSingleResult();
		SupermarketBean supermarketBean = new SupermarketBean();
		supermarketBean.setSupermarketId(supermarket.getSupermarketId());
		supermarketBean.setSupermarketName(supermarket.getSupermarketName());
		supermarketBean.setNotice(supermarket.getNotice());
		supermarketBean.setSuperRegion(supermarket.getSuperRegion());
		supermarketBean.setDatetime(supermarket.getDatetime());
		return supermarketBean;
	}

}
