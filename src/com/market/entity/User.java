package com.market.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * 用户表
 * @author
 *
 */
@Entity
public class User {
	/**
	 * 用户id
	 */
	@Id
	private int userId;
	/**
	 * 用户名
	 */
	@Column(length=20,nullable=false)
	private String userName;
	/**
	 * 密码
	 */
	@Column(length=16,nullable=false)
	private String password;
	/**
	 * 手机
	 */
	@Column(length=11,nullable=false)
	private String userPhone;
	/**
	 * 性别
	 */
	@Column
	private int sex;
	/**
	 * 头像
	 */
	@Column(length=100)
	private String portrait;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private Set<Message> messages=new HashSet<Message>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private Set<Address> address=new HashSet<Address>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private Set<ShopCart> shopCart=new HashSet<ShopCart>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private Set<Order> order=new HashSet<Order>();

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
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public Set<ShopCart> getShopCart() {
		return shopCart;
	}
	public void setShopCart(Set<ShopCart> shopCart) {
		this.shopCart = shopCart;
	}
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
}