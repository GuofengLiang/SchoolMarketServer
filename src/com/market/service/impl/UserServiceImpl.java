package com.market.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.UserDao;
import com.market.entity.User;
import com.market.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Resource(name="userDaoImpl")
    UserDao userDao;
	@Override
	public User findSingleUser(String username) {
		User user=userDao.findSingleUser(username);
		return user;
	}

}
