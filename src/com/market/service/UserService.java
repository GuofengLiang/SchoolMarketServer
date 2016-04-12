package com.market.service;

import com.market.entity.User;

public interface UserService {
	/**
	   * 通过用户的id来查找用户
	   * @param username
	   * @return
	   */
	  User findSingleUser(String username);
}