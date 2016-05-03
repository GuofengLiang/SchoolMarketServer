package com.market.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.UserDao;
import com.market.entity.User;
import com.market.javabean.UserBean;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public User findSingleUser(String username) {
		Query query = entityManager
				.createQuery("select u from User u where u.userName=?1");
		query.setParameter(1, username);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Transactional
	@Override
	public void updatePassword(String username, String oldPassword,
			String newPassword) throws Exception {
		Query query = entityManager
				.createQuery("select u from User u where u.userName=?1");
		query.setParameter(1, username);
		User user = (User) query.getSingleResult();
		if (!user.getPassword().equals(oldPassword)) {
			throw new Exception();
		}
		user.setPassword(newPassword);

	}

	@Override
	@Transactional
	public void addSingleUser(String userName, String password,
			String userPhone, int sex, String portrait) {
		// 持久化user
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserPhone(userPhone);
		user.setSex(sex);
		user.setPortrait(portrait);
		entityManager.persist(user); // 保存到数据库
	}

	/**
	 * 根据用户用户名查找用户信息
	 */
	@Override
	public UserBean findUserByName(String username) {
		Query query = entityManager.createQuery("select s from User s where s.userName=?1");
		query.setParameter(1, username);
		User user = (User) query.getSingleResult();
		UserBean userBean = new UserBean();
		userBean.setUserId(user.getUserId());
		userBean.setUserName(user.getUserName());
		userBean.setUserPhone(user.getUserPhone());
		userBean.setSex(user.getSex());
		userBean.setPortrait(user.getPortrait());
		return userBean;
	}
	/**
	 * 根据用户用户手机号码查找用户信息
	 */
	@SuppressWarnings("null")
	@Override
	public UserBean findUserByPhone(String userPhone) {
		Query query = entityManager.createQuery("select s from User s where s.userPhone=?1");
		query.setParameter(1, userPhone);
		User user = (User) query.getSingleResult();
		UserBean userBean = new UserBean();
		userBean.setUserId(user.getUserId());
		userBean.setUserName(user.getUserName());
		userBean.setUserPhone(user.getUserPhone());
		userBean.setSex(user.getSex());
		userBean.setPortrait(user.getPortrait());
		return userBean;
	}

	/**
	 * 根据用户手机查找用户
	 */
	@Override
	public User findUserByUPhone(String userPhone) {
		Query query = entityManager.createQuery("select u from User u where u.userPhone=?1");
		query.setParameter(1, userPhone);
		User user = (User) query.getSingleResult();
		return user;
	}

	/**
	 * 根据手机号码查找用户	//用于登录后返回数据
	 */
	@Override
	public Map<String, Object> findObjectUserByPhone(String userPhone) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = findUserByUPhone(userPhone);
		map.put("user", user);
		return map;
	}

	@Override
	@Transactional
	public void registerNewUser(String userPhone, String password) {
		// 持久化user
		User user = new User();
		user.setUserPhone(userPhone);
		user.setPassword(password);
		entityManager.persist(user); // 保存到数据库
		
	}
}
