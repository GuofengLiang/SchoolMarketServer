package com.market.javabean;

public class UserBean {

	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 
	private String password;*/
	/**
	 * 手机
	 */
	private String userPhone;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 头像
	 */
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
/* 	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	*/
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
