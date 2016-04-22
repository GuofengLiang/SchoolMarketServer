package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.MainClassifyDao;
import com.market.entity.MainClassify;
import com.market.entity.SubClassify;

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
	public void delectClassify(int mainclassId) {
		/**
		 * 这里还需要添加一些其他的删除
		 */
//		Query query = entityManager.createQuery("select s from SubClassify s where s.mainclassId.mainclassId=?1");
//		query.setParameter(1, mainclassId);
//		@SuppressWarnings("unchecked")
//		List<SubClassify> lists=query.getResultList();
//		for (SubClassify list : lists) {
//			entityManager.remove(list);
//			}
		MainClassify mainClassify=entityManager.find(MainClassify.class, mainclassId);
		entityManager.remove(mainClassify);
	}
}
