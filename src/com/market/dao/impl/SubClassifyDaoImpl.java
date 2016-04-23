package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.SubClassifyDao;
import com.market.entity.MainClassify;
import com.market.entity.SubClassify;
import com.market.javabean.SubClassBean;
import com.market.javabean.SubClassifyBean;
@Repository
public class SubClassifyDaoImpl implements SubClassifyDao {
	@PersistenceContext
	protected EntityManager entityManager;
	/**
	 * 根据mainclassId查找其下所有的子分类
	 */
	@Override
	public List<SubClassifyBean> findAllSubClassify(int mainclassId) {
		Query query = entityManager.createQuery("select s from SubClassify s where s.mainclassId.mainclassId=?1");
		query.setParameter(1, mainclassId);
		@SuppressWarnings("unchecked")
		List<SubClassify> list=query.getResultList();
		List<SubClassifyBean> listbean=new ArrayList<SubClassifyBean>();
		for(int i=0;i<list.size();i++){
			SubClassifyBean subClassifyBean=new SubClassifyBean();
			subClassifyBean.setSubclassId(list.get(i).getSubclassId());
			subClassifyBean.setSubclassName(list.get(i).getSubclassName());
			listbean.add(subClassifyBean);
		}
		return listbean;
	}
	@Override
		/**
	    * 查询所有子分类的信息
	    * @return
	    */
	public List<SubClassBean> findAllSubClassifies() {
		Query query = entityManager.createQuery("select s from SubClassify s order by s.subclassId desc");
		@SuppressWarnings({ "unchecked", "unused" })
		List<SubClassify> subClass = query.getResultList();
		List<SubClassBean> subClassBeans=new ArrayList<SubClassBean>();
		for(SubClassify sub:subClass){
			SubClassBean subClassBean=new SubClassBean();
			subClassBean.setSubclassId(sub.getSubclassId());
			subClassBean.setSubclassName(sub.getSubclassName());
			subClassBean.setMainclassId(sub.getMainclassId().getMainclassId());
			subClassBean.setMainclassName(sub.getMainclassId().getMainclassName());
			subClassBeans.add(subClassBean);
		}
		return subClassBeans;
	}
	/**
	 * 添加子分类
	 */
	@Override
	@Transactional
	public void addSubClassify(String subclassName, int mainclassId) {
		//通过mainclassId获取主分类
		Query query = entityManager.createQuery("select m from MainClassify m where m.mainclassId=?1");
		query.setParameter(1, mainclassId);
		MainClassify mainClassify = (MainClassify)query.getSingleResult();
		//持久化subClassify
		SubClassify subClassify = new SubClassify();
		subClassify.setSubclassName(subclassName);
		subClassify.setMainclassId(mainClassify);
		entityManager.persist(subClassify);
	}
	/**
	 * 根据subclassId查找单个子分类信息
	 */
	@Override
	@Transactional
	public SubClassify findSingleSubClassify(int subclassId) {
		Query query = entityManager.createQuery("select s from SubClassify s where s.subclassId=?1");
		query.setParameter(1, subclassId);
		SubClassify subClassify = (SubClassify) query.getSingleResult();
		return subClassify;
	}
	   /**
		 * 根据mainclassId来查找主分类
		 */
	@Override
	@Transactional
	public MainClassify findSingleMainClassify(int mainclassId) {
			Query query = entityManager.createQuery("select m from MainClassify m where m.mainclassId=?1");
			query.setParameter(1, mainclassId);
			MainClassify mainClassify = (MainClassify)query.getSingleResult();
			return mainClassify;
		}
	/**
	 * 修改分类的信息
	 */
	@Override
	@Transactional
	public void alterClassify(int subclassId, String subclassName, String mainclassName) {
		   SubClassify subClassify = findSingleSubClassify(subclassId);
		   MainClassify mainClassify = findSingleMainClassify(subClassify.getMainclassId().getMainclassId());
		   mainClassify.setMainclassName(mainclassName);
		   subClassify.setSubclassName(subclassName);
		//   return subClassify;
	   }
}
