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
	public Admin findSingleAdmin(String adminName) {
		Query query = entityManager
				.createQuery("select a from Admin a where a.adminName=?1");
		query.setParameter(1, adminName);
		try {
			Admin amdin = (Admin) query.getSingleResult();
			return amdin;
		} catch (Exception e) {
			return null;
		}
	}

}
