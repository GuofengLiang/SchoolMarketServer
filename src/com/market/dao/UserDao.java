package com.market.dao;

import com.market.entity.User;

public interface UserDao {
  /**
   * 通过用户的id来查找用户
   * @param username
   * @return
   */
  User findSingleUser(String username);
  /**
   * 
   */
  void addsingleUser();
}
