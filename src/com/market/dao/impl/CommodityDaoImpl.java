package com.market.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.CommodityDao;
import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
@Repository
public class CommodityDaoImpl implements CommodityDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public Commodity findSingleComm(int commodityId) {

		Query query =entityManager.createQuery("select s from Commodity s where s.commodityId=?1");
		query.setParameter(1, commodityId);
		Commodity commodity=  (Commodity) query.getSingleResult();
		return commodity;
	}

}
