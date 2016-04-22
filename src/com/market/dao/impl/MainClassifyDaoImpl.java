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

	/**
	 * 修改主分类
	 */
	@Override
	@Transactional
	public void alterMainClassify(int mainclassId, String mainclassName) {
		Query query = entityManager.createQuery("select m from MainClassify m where m.mainclassId=?1");
		query.setParameter(1, mainclassId);
		MainClassify mainClassify = (MainClassify)query.getSingleResult();
		mainClassify.setMainclassName(mainclassName);
	}
	/**
	 * 根据mainclassId来查找主分类
	 */
	@Override
	public MainClassify findSingleMainClassify(int mainclassId) {
		Query query = entityManager.createQuery("select m from MainClassify m where m.mainclassId=?1");
		query.setParameter(1, mainclassId);
		MainClassify mainClassify = (MainClassify)query.getSingleResult();
		return mainClassify;
	}
}
