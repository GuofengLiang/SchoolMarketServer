package com.market.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.market.javabean.CommodityBean;
import com.market.javabean.SubClassifyBean;

@Repository
public class CommodityDaoImpl implements CommodityDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 根据商品id来查找该商品的信息
	 */
	@Override
	public CommodityBean findSingleComm(int commodityId) {

		Query query = entityManager
				.createQuery("select s from Commodity s where s.commodityId=?1");
		query.setParameter(1, commodityId);
		Commodity commodity = (Commodity) query.getSingleResult();
		CommodityBean commodityBean = new CommodityBean();
		commodityBean.setCommodityId(commodity.getCommodityId());
    	commodityBean.setCommName(commodity.getCommName());
    	commodityBean.setDescribes(commodity.getDescribes());
    	commodityBean.setDiscount(commodity.getDiscount());
    	commodityBean.setMainclassId(commodity.getMainclassId().getMainclassId());
    	commodityBean.setMainclassName(commodity.getMainclassId().getMainclassName());
    	commodityBean.setPicture(commodity.getPicture());
    	commodityBean.setPrice(commodity.getPrice());
    	commodityBean.setSales(commodity.getSales());
    	commodityBean.setSpecialTime(commodity.getSpecialTime());
    	commodityBean.setSpercification(commodity.getSpercification());
    	commodityBean.setStock(commodity.getStock());
    	commodityBean.setSubclassId(commodity.getSubclassId().getSubclassId());
    	commodityBean.setSubclassName(commodity.getSubclassId().getSubclassName());
    	commodityBean.setType(commodity.getType());
		return commodityBean;
	}

	/**
	 * 添加单个商品
	 */
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
	public List<CommodityBean> findAllCommByType(String type) {
		Query query = entityManager.createQuery("select s from Commodity s where s.type=?1");
		query.setParameter(1, type);
		@SuppressWarnings("unchecked")
		List<Commodity> commodity = query.getResultList();
		List<CommodityBean> commodityListBean = new ArrayList<CommodityBean>();
		for(int i = 0; i<commodity.size(); i++) {
			CommodityBean commodityBean = new CommodityBean();
			commodityBean.setCommodityId(commodity.get(i).getCommodityId());
	    	commodityBean.setCommName(commodity.get(i).getCommName());
	    	commodityBean.setDescribes(commodity.get(i).getDescribes());
	    	commodityBean.setDiscount(commodity.get(i).getDiscount());
	    	commodityBean.setMainclassId(commodity.get(i).getMainclassId().getMainclassId());
	    	commodityBean.setMainclassName(commodity.get(i).getMainclassId().getMainclassName());
	    	commodityBean.setPicture(commodity.get(i).getPicture());
	    	commodityBean.setPrice(commodity.get(i).getPrice());
	    	commodityBean.setSales(commodity.get(i).getSales());
	    	commodityBean.setSpecialTime(commodity.get(i).getSpecialTime());
	    	commodityBean.setSpercification(commodity.get(i).getSpercification());
	    	commodityBean.setStock(commodity.get(i).getStock());
	    	commodityBean.setSubclassId(commodity.get(i).getSubclassId().getSubclassId());
	    	commodityBean.setSubclassName(commodity.get(i).getSubclassId().getSubclassName());
	    	commodityBean.setType(commodity.get(i).getType());
	    	commodityListBean.add(commodityBean);
		}
		return commodityListBean;
	}

	/**
	 * 根据超市id和主分类id查找商品
	 */
	@Override
	public List<Commodity> findAllCommByMclass(int supermartketId, int mainclassId) {
		Query query = entityManager.createQuery("select s from Commodity s where s.supermartketId=?1 and s.mainclassId=?2");
		query.setParameter(1, supermartketId);
		query.setParameter(2, mainclassId);
		@SuppressWarnings("unchecked")
		List<Commodity> commodities = query.getResultList();
		/*List<CommodityBean> commodityListBean = new ArrayList<CommodityBean>();
		for(int i = 0; i<commodities.size(); i++) {
			CommodityBean commodityBean = new CommodityBean();
			commodityBean.setCommName(commodities.get(i).getCommName());
			commodityBean.setCommodityId(commodities.get(i).getCommodityId());
			commodityBean.setDescribes(commodities.get(i).getDescribes());
			commodityBean.setDiscount(commodities.get(i).getDiscount());
			commodityBean.setMainclassName(commodities.get(i).getMainclassId().getMainclassName());
			commodityBean.setPicture(commodities.get(i).getPicture());
			commodityBean.setPrice(commodities.get(i).getPrice());
			commodityBean.setSales(commodities.get(i).getSales());
			commodityBean.setSpecialTime(commodities.get(i).getSpecialTime());
			commodityBean.setSpercification(commodities.get(i).getSpercification());
			commodityBean.setStock(commodities.get(i).getStock());
			commodityBean.setSubclassName(commodities.get(i).getSubclassId().getSubclassName());
			commodityBean.setType(commodities.get(i).getType());
			commodityListBean.add(commodityBean);
		}*/
		return commodities;
	}

	/**
	 * 根据主分类id来查找该分类下的所有商品
	 */
	@Override
	public List<CommodityBean> findAllCommByMainId(int mainclassId) {
		Query query = entityManager
				.createQuery("select s from Commodity s where s.mainclassId.mainclassId=?1");
		query.setParameter(1, mainclassId);
		@SuppressWarnings("unchecked")
		List<Commodity> commodity = query.getResultList();
		List<CommodityBean> commodityListBean = new ArrayList<CommodityBean>();
		for(int i = 0; i<commodity.size(); i++) {
			CommodityBean commodityBean = new CommodityBean();
			commodityBean.setCommodityId(commodity.get(i).getCommodityId());
	    	commodityBean.setCommName(commodity.get(i).getCommName());
	    	commodityBean.setDescribes(commodity.get(i).getDescribes());
	    	commodityBean.setDiscount(commodity.get(i).getDiscount());
	    	commodityBean.setMainclassId(commodity.get(i).getMainclassId().getMainclassId());
	    	commodityBean.setMainclassName(commodity.get(i).getMainclassId().getMainclassName());
	    	commodityBean.setPicture(commodity.get(i).getPicture());
	    	commodityBean.setPrice(commodity.get(i).getPrice());
	    	commodityBean.setSales(commodity.get(i).getSales());
	    	commodityBean.setSpecialTime(commodity.get(i).getSpecialTime());
	    	commodityBean.setSpercification(commodity.get(i).getSpercification());
	    	commodityBean.setStock(commodity.get(i).getStock());
	    	commodityBean.setSubclassId(commodity.get(i).getSubclassId().getSubclassId());
	    	commodityBean.setSubclassName(commodity.get(i).getSubclassId().getSubclassName());
	    	commodityBean.setType(commodity.get(i).getType());
	    	commodityListBean.add(commodityBean);
		}
		return commodityListBean;
	}

	/**
	 * 查找热卖商品
	 * 按照sales来查找销量前六的商品
	 */
	@Override
	public List<CommodityBean> findSixCommBySales() {
		//Query query1 = entityManager.createQuery("select c from Commodity c where c.type = '推荐商品'");
		Query query = entityManager.createQuery("select s from Commodity s order by s.sales desc");
		@SuppressWarnings("unchecked")
		List<CommodityBean> commodityListBean = new ArrayList<CommodityBean>();
		@SuppressWarnings("unchecked")
		List<Commodity> commodity = query.getResultList();
		int n;	//限制只显示n个热卖商品
		if(commodity.size()>6) {
			n = 6;
		}
		else
			n = commodity.size();
		for(int i = 0; i<n; i++) {
			CommodityBean commodityBean = new CommodityBean();
			commodityBean.setCommodityId(commodity.get(i).getCommodityId());
	    	commodityBean.setCommName(commodity.get(i).getCommName());
	    	commodityBean.setDescribes(commodity.get(i).getDescribes());
	    	commodityBean.setDiscount(commodity.get(i).getDiscount());
	    	commodityBean.setMainclassId(commodity.get(i).getMainclassId().getMainclassId());
	    	commodityBean.setMainclassName(commodity.get(i).getMainclassId().getMainclassName());
	    	commodityBean.setPicture(commodity.get(i).getPicture());
	    	commodityBean.setPrice(commodity.get(i).getPrice());
	    	commodityBean.setSales(commodity.get(i).getSales());
	    	commodityBean.setSpecialTime(commodity.get(i).getSpecialTime());
	    	commodityBean.setSpercification(commodity.get(i).getSpercification());
	    	commodityBean.setStock(commodity.get(i).getStock());
	    	commodityBean.setSubclassId(commodity.get(i).getSubclassId().getSubclassId());
	    	commodityBean.setSubclassName(commodity.get(i).getSubclassId().getSubclassName());
	    	commodityBean.setType(commodity.get(i).getType());
	    	commodityListBean.add(commodityBean);
		}
		
		return commodityListBean;
	}

	
	/**
	 * 查找热卖商品
	 * 按照sales来查找销量前六的商品
	 */
	@Override
	public List<CommodityBean> findSixCommByRecomoend() {
		Query query = entityManager.createQuery("select c from Commodity c where c.type = '推荐商品'");
		List<CommodityBean> commodityListBean = new ArrayList<CommodityBean>();
		@SuppressWarnings("unchecked")
		List<Commodity> commodity = query.getResultList();
		int n;	//限制只显示n个热卖商品
		if(commodity.size()>6) {
			n = 6;
		}
		else
			n = commodity.size();
		for(int i = 0; i<n; i++) {
			CommodityBean commodityBean = new CommodityBean();
			commodityBean.setCommodityId(commodity.get(i).getCommodityId());
	    	commodityBean.setCommName(commodity.get(i).getCommName());
	    	commodityBean.setDescribes(commodity.get(i).getDescribes());
	    	commodityBean.setDiscount(commodity.get(i).getDiscount());
	    	commodityBean.setMainclassId(commodity.get(i).getMainclassId().getMainclassId());
	    	commodityBean.setMainclassName(commodity.get(i).getMainclassId().getMainclassName());
	    	commodityBean.setPicture(commodity.get(i).getPicture());
	    	commodityBean.setPrice(commodity.get(i).getPrice());
	    	commodityBean.setSales(commodity.get(i).getSales());
	    	commodityBean.setSpecialTime(commodity.get(i).getSpecialTime());
	    	commodityBean.setSpercification(commodity.get(i).getSpercification());
	    	commodityBean.setStock(commodity.get(i).getStock());
	    	commodityBean.setSubclassId(commodity.get(i).getSubclassId().getSubclassId());
	    	commodityBean.setSubclassName(commodity.get(i).getSubclassId().getSubclassName());
	    	commodityBean.setType(commodity.get(i).getType());
	    	commodityListBean.add(commodityBean);
		}
		
		return commodityListBean;
	}
	/**
	 * 查找推荐商品和热卖商品
	 */
	@Override
	public List<Map<String, Object>> findSaleAndSpecialComm() {
		List<Map<String,Object>> commodities=new ArrayList<Map<String,Object>>();
			Map<String,Object> map=new HashMap<String,Object>();
			List<CommodityBean> HotSaleComm = findSixCommBySales();
			List<CommodityBean> RecommendComm = findSixCommByRecomoend();
			map.put("热卖商品", HotSaleComm);
			map.put("推荐商品", RecommendComm);
			commodities.add(map);
		return commodities;
	}

}
