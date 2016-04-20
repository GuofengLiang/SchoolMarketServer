package com.market.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.CommodityDao;
import com.market.entity.Commodity;
import com.market.entity.MainClassify;
import com.market.entity.SubClassify;
import com.market.entity.Supermarket;

@Repository
public class CommodityDaoImpl implements CommodityDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Commodity findSingleComm(int commodityId) {

		Query query = entityManager
				.createQuery("select s from Commodity s where s.commodityId=?1");
		query.setParameter(1, commodityId);
		Commodity commodity = (Commodity) query.getSingleResult();
		return commodity;
	}

	@Override
	@Transactional
	public void addSingleCommodity(String mainclassName, String subclassName,
			String commName, String picture, float price,
			String spercification, String describes, int stock, float discount,
			Date specialTime, String type, int supermarketId) {
		// 持久化mainClassify
		MainClassify mainclass = new MainClassify();
		mainclass.setMainclassName(mainclassName);
		entityManager.persist(mainclass);
		// 持久化subClassify
		SubClassify subclass = new SubClassify();
		subclass.setSubclassName(subclassName);
		subclass.setMainclassId(mainclass);
		entityManager.persist(subclass);
		// 持久化commodity
		Commodity commodity = new Commodity();
		commodity.setCommName(commName);
		commodity.setPicture(picture);
		commodity.setPrice(price);
		commodity.setSpercification(spercification);
		commodity.setDescribes(describes);
		commodity.setStock(stock);
		commodity.setDiscount(discount);
		commodity.setSpecialTime(specialTime);
		commodity.setType(type);
		commodity.setMainclassId(mainclass);
		commodity.setSubclassId(subclass);
		entityManager.persist(commodity);
		// 得到supermarket
		Query query = entityManager
				.createQuery("select s from Supermarket s where s.supermarketId=?1");
		query.setParameter(1, supermarketId);
		Supermarket supermarket = (Supermarket) query.getSingleResult();
		// 保存
		supermarket.getCommodity().add(commodity);

	}

}
