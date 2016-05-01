package com.market.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.dao.UserDao;
import com.market.entity.User;
import com.market.javabean.UserBean;
import com.market.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource(name = "userDaoImpl")
	UserDao userDao;

	/**
	 * 根据用户名查找用户信息	//用于用户名登录
	 */
	@Override
	public User findSingleUser(String username) {
		User user = userDao.findSingleUser(username);
		return user;
	}

	@Override
	public void updatePassword(String username, String oldPassword,
			String newPassword) throws Exception {
		userDao.updatePassword(username, oldPassword, newPassword);
	}

	@Override
	public void addSingleUser(String userName, String password,
			String userPhone, int sex, String portrait,
			MultipartHttpServletRequest mRequest) {
		userDao.addSingleUser(userName, password, userPhone, sex, portrait);
	}

	/**
	 * 根据用户手机号码查找用户信息
	 */
	@Override
	public UserBean findUserByPhone(String userPhone) {
		UserBean userBean = userDao.findUserByPhone(userPhone);
		return userBean;
	}

	/**
	 * 根据用户手机查找用户
	 */
	@Override
	public User findUserByUPhone(String userPhone) {
		User user = userDao.findUserByUPhone(userPhone);
		return user;
	}

	/**
	 * 根据手机号码查找用户	//用于登录后返回数据
	 * @param userPhone
	 * @return
	 */
	@Override
	public Map<String, Object> findObjectUserByPhone(String userPhone) {
		Map<String, Object> map = userDao.findObjectUserByPhone(userPhone);
		return map;
	}
}
