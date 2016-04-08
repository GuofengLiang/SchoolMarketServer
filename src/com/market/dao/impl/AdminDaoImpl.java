package com.market.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.AdminDao;
import com.market.entity.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public Admin findSingleUser(String adminname) {
		Query query = entityManager
				.createQuery("select a from Admin a where a.adminname=?1");
		query.setParameter(1, adminname);
		try {
			Admin teacher = (Admin) query.getSingleResult();
			return teacher;
		} catch (Exception e) {
			return null;
		}
	}

}
