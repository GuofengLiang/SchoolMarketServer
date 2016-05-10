package com.market.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.entity.User;
import com.market.javabean.UserBean;

public interface UserService {
	/**
	 * 通过用户的id来查找用户
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
			int sex, String portrait, // 头像
			MultipartHttpServletRequest mRequest) throws Exception;
	/**
	 * 注册新用户
	 * @param userPhone
	 * @param password
	 */
	void registerNewUser(String userPhone, String password);
	/**
	 * 根据用户用户名查找用户信息
	 * @param userPhone
	 * @return
	 */
	UserBean findUserByName(String username);
	/**
	 * 根据用户用户手机号码查找用户信息
	 * @param userPhone
	 * @return
	 */
	UserBean findUserByPhone(String userPhone);
	/**
	 * 根据手机号码查找用户信息
	 * @return
	 */
	User findUserByUPhone(String userPhone);
	/**
	 * 根据手机号码查找用户	//用于登录后返回数据
	 * @param userPhone
	 * @return
	 */
	Map<String,Object> findObjectUserByPhone(String userPhone);
	/**
	 * 修改用户信息
	 * @param userId
	 * @param userName
	 * @param userPhone
	 * @param sex
	 * @param portrait
	 */
	void alterUser(int userId, String userName, String userPhone, int sex, String portrait);
}
