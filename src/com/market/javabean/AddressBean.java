package com.market.javabean;

import com.market.entity.User;

public class AddressBean {

	private int addressId;
	/**
	 * 用户id
	 */
	private User user;
	/**
	 * 详细地址
	 */
	private String addressDetail;
	/**
	 * 收件人
	 */
	private String consignee;
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
	/**
	 * 电话号码
	 */
	private String phone;
}
