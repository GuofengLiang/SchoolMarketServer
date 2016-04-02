package com.market.dao;

import com.market.entity.User;

public interface UserDao {
  User findSingleUser(String username);
}
