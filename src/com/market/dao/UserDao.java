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
   * 根据新的密码来修改验证码
   * @param username
   * @param oldPassword
   * @param newPassword
   * @throws Exception
   */
  void updatePassword(String username,String oldPassword,String newPassword)throws Exception;
}
