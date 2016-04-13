package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.ClassificationDao;
import com.market.entity.Classification;
import com.market.entity.Commodity;

@Repository
public class ClassificationDaoImpl implements ClassificationDao {
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Commodity> findAllCommodity(int classId) {
	
		Query query = entityManager.createQuery("select c from Classification c where c.classId=?11");
		query.setParameter(11, classId);
		Classification classification= (Classification) query.getSingleResult();
		Set<Commodity> commodities = classification.getCommodity();
		List<Commodity> list = new ArrayList<Commodity>(commodities);
		return list;
	}

	@Override
	public Classification findSingleClass(int classId) {
		
		Query query = entityManager.createQuery("select c from Classification c where c.classId=?1");
		query.setParameter(1, classId);
		Classification classification = (Classification) query.getSingleResult();
		return classification;
	}

}
