package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.SubClassifyDao;
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
			subClassifyBean.setSubclassName(list.get(i).getSubclassName());
			listbean.add(subClassifyBean);
		}
		return listbean;
	}

}
