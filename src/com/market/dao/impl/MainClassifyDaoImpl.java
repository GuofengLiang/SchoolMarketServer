package com.market.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.MainClassifyDao;
import com.market.entity.MainClassify;

@Repository
public class MainClassifyDaoImpl implements MainClassifyDao {
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<MainClassify> findAllMainClassify() {
		Query query = entityManager.createQuery("select s from MainClassify s");
		@SuppressWarnings("unchecked")
		List<MainClassify> mainClassifies =query.getResultList();
		return mainClassifies;
	}
	@Override
	@Transactional
	public void addMainClassify(String mainclassName) {
		//持久化mainclassify
		MainClassify mainClassify = new MainClassify();
		mainClassify.setMainclassName(mainclassName);
		entityManager.persist(mainClassify);
	}

}
