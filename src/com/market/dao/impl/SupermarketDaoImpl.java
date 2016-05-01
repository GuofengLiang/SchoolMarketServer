package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.SupermarketDao;
import com.market.entity.Advertise;
import com.market.entity.Commodity;
import com.market.entity.Supermarket;
import com.market.javabean.AdvertiseBean;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;

@Repository
public class SupermarketDaoImpl implements SupermarketDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 根据超市id查找所有商品信息
	 */
	@Override
	public List<CommodityBean> findAllCommodity(int supermarketId) {
		Query query = entityManager.createQuery("select s from Supermarket s where s.supermarketId=?1");
		query.setParameter(1, supermarketId);
		Supermarket supermarket = (Supermarket) query.getSingleResult();
		Set<Commodity> commodities = supermarket.getCommodity();
		List<Commodity> list = new ArrayList<Commodity>(commodities);
		List<CommodityBean> listbean = new ArrayList<CommodityBean>();
        for(Commodity comm:list){
        	CommodityBean commodityBean=new CommodityBean();
        	commodityBean.setCommodityId(comm.getCommodityId());
        	commodityBean.setCommName(comm.getCommName());
        	commodityBean.setDescribes(comm.getDescribes());
        	commodityBean.setDiscount(comm.getDiscount());
        	commodityBean.setMainclassId(comm.getMainclassId().getMainclassId());
        	commodityBean.setMainclassName(comm.getMainclassId().getMainclassName());
        	commodityBean.setPicture(comm.getPicture());
        	commodityBean.setPrice(comm.getPrice());
        	commodityBean.setSales(comm.getSales());
        	commodityBean.setSpecialTime(comm.getSpecialTime());
        	commodityBean.setSpercification(comm.getSpercification());
        	commodityBean.setStock(comm.getStock());
        	commodityBean.setSubclassId(comm.getSubclassId().getSubclassId());
        	commodityBean.setSubclassName(comm.getSubclassId().getSubclassName());
        	commodityBean.setType(comm.getType());
        	listbean.add(commodityBean);
        }
		return listbean;
	}

	/**
	 * 通过超市id查找超市信息
	 */
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
	/**
	 * 根据超市id查找所有广告信息
	 */
	@Override
	public List<AdvertiseBean> findAllAdvertises(int supermarketId) {
		Query query = entityManager.createQuery("select s from Advertise s where s.supermarket.supermarketId=?1");
		query.setParameter(1, supermarketId);
		@SuppressWarnings("unchecked")
		List<Advertise> advertise = query.getResultList();
		List<AdvertiseBean> advertiseListBean = new ArrayList<AdvertiseBean>();
		for(int i = 0; i<advertise.size(); i++) {
			AdvertiseBean advertiseBean = new AdvertiseBean();
			advertiseBean.setAdvertiseId(advertise.get(i).getAdvertiseId());
			advertiseBean.setAdvertisePic(advertise.get(i).getAdvertisePic());
			advertiseBean.setLinkContent(advertise.get(i).getLinkContent());
			advertiseListBean.add(advertiseBean);
		}
		return advertiseListBean;
	}

}
