package com.market.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.dao.UserDao;
import com.market.entity.User;
import com.market.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource(name = "userDaoImpl")
	UserDao userDao;

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
}
