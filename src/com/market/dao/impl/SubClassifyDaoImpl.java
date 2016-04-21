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
import com.market.javabean.SubClassifyBean;
@Repository
public class SubClassifyDaoImpl implements SubClassifyDao {
	@PersistenceContext
	protected EntityManager entityManager;
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
			listbean.add(subClassifyBean);
		}
		return listbean;
	}
	@Override
		/**
	    * 查询所有子分类的信息
	    * @return
	    */
	public List<SubClassify> findAllSubClassifies() {
		Query query = entityManager.createQuery("select s from SubClassify s");
		@SuppressWarnings("unchecked")
		List<SubClassify> subClass = query.getResultList();
		return subClass;
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

}
