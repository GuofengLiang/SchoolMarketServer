package com.market.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.SubClassifyDao;
import com.market.entity.SubClassify;
@Repository
public class SubClassifyDaoImpl implements SubClassifyDao {
	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public List<SubClassify> findAllSubClassify(int mainclassId) {
		Query query = entityManager.createQuery("select s from SubClassify s where s.mainclassId=?1");
		query.setParameter(1, mainclassId);
		@SuppressWarnings("unchecked")
		List<SubClassify> list=query.getResultList();
		return list;
	}

}
