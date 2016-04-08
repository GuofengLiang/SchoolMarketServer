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

@Repository
public class SupermarketDaoImpl implements SupermarketDao{
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Commodity> findAllCommodity(int supermarketId) {
		Query query = entityManager.createQuery("select s from Supermarket s where s.supermarketId=?1");
		query.setParameter(1, supermarketId);
		Supermarket supermarket=  (Supermarket) query.getSingleResult();
		Set<Commodity> commodities=supermarket.getCommodity();
		List<Commodity> list = new ArrayList<Commodity>(commodities);
		return list;
	}

}
