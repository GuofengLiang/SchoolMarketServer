package com.market.dao;

import java.util.Map;

import com.market.entity.User;
import com.market.javabean.UserBean;

public interface UserDao {
	/**
	 * 通过用户名来查找用户
	 * 
	 * @param username
	 * @return
	 */
	User findSingleUser(String username);

	/**
	 * 根据新的密码来修改验证码
	 * 
	 * @param username
	 * @param oldPassword
	 * @param newPassword
	 * @throws Exception
	 */
	void updatePassword(String username, String oldPassword, String newPassword)
			throws Exception;

	/**
	 * 添加单个用户信息
	 * 
	 * @param userName
	 * @param password
	 * @param userPhone
	 * @param sex
	 * @param portrait
	 */
	void addSingleUser(String userName, String password, String userPhone,
			int sex, String portrait // 头像
	);
	/**
	 * 注册新用户
	 * @param userName
	 * @param password
	 */
	void registerNewUser(String userName, String password);
	/**
	 * 根据用户名查找用户信息
	 * @param userPhone
	 * @return
	 */
	UserBean findUserByName(String username);
	/**
	 * 根据用户手机号码查找用户信息
	 * @param userPhone
	 * @return
	 */
	UserBean findUserByPhone(String userPhone);
	/**
	 * 根据用户手机查找用户	//通过手机号码登录用到
	 * @param userPhone
	 * @return
	 */
	User findUserByUPhone(String userPhone);
	/**
	 * 根据手机号码查找用户	//用于登录后返回数据
	 * @param userPhone
	 * @return
	 */
	Map<String,Object> findObjectUserByPhone(String userPhone);
}
