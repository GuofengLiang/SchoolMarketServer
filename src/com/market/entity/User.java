package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户表
 * 
 * @author
 * 
 */
@Entity
public class User {
	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	/**
	 * 用户名
	 */
	@Column(length = 20, nullable = false)
	private String userName;
	/**
	 * 密码
	 */
	@Column(length = 16, nullable = false)
	private String password;
	/**
	 * 手机
	 */
	@Column(length = 11, nullable = false)
	private String userPhone;
	/**
	 * 性别
	 */
	@Column
	private int sex;
	/**
	 * 头像
	 */
	@Column(length = 100)
	private String portrait;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
}