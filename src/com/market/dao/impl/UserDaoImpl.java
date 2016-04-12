package com.market.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.UserDao;
import com.market.entity.User;
@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public User findSingleUser(String username) {
		Query query = entityManager.createQuery("select u from User u where u.userName=?1");
		query.setParameter(1, username);
			User user= (User) query.getSingleResult();
			return user;
	}

}
