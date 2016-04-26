package com.market.dao.impl;

import java.util.Date;
import java.util.List;

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
	public void addSingleCommodity(int mainclassId, int subclassId,
			String commName, String picture, float price,
			String spercification, String describes, int stock, float discount,
			Date specialTime, String type, int supermarketId) {
		//根据mainclassId获得一个大分类
		Query query1 = entityManager.createQuery("select m from MainClassify m where m.mainclassId=?1");
		query1.setParameter(1, mainclassId);
		MainClassify mainclass = (MainClassify) query1.getSingleResult();
		//根据subclassId获得一个小分类
		Query query2 = entityManager.createQuery("select s from SubClassify s where s.subclassId=?1");
		query2.setParameter(1, subclassId);
		SubClassify subclass = (SubClassify) query2.getSingleResult();
		subclass.setMainclassId(mainclass);
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
		Query query3= entityManager
				.createQuery("select s from Supermarket s where s.supermarketId=?1");
		query3.setParameter(1, supermarketId);
		Supermarket supermarket = (Supermarket) query3.getSingleResult();
		// 保存
		supermarket.getCommodity().add(commodity);

	}

	/**
	 * 根据type类型来查找商品
	 */
	@Override
	public List<Commodity> findAllCommByType(String type) {
		Query query = entityManager.createQuery("select s from Commodity s where s.type=?1");
		query.setParameter(1, type);
		@SuppressWarnings("unchecked")
		List<Commodity> commType = query.getResultList();
		return commType;
	}

}
