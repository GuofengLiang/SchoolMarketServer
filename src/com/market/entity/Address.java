package com.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 * 收货地址表
 * @author 
 *
 */
@Entity
public class Address {

	/**
	 * 收货地址编号
	 */
	@Id
	private int addressId;
	/**
	 * 用户id
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="user_id")
	private User user;
	/**
	 * 详细地址
	 */
	@Column(length=40,nullable=false)
	private String addressDetail;
	
	/**
	 * 收件人
	 */
	@Column(length=4,nullable=false)
	private String consignee;
	/**
	 * 电话号码
	 */
	@Column(length=11)
	private String phone;
	
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy="addressId") 
	private Order order;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}