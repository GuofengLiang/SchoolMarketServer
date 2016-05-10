package com.market.javabean;

import com.market.entity.User;

public class AddressBean {

	private int addressId;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 详细地址
	 */
	private String addressDetail;
	/**
	 * 收件人
	 */
	private String consignee;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 默认地址标识
	 */
	private int defaultedAddress;
	/**
	 * 运费
	 */
	private float freight;
	public int getDefaultedAddress() {
		return defaultedAddress;
	}
	public void setDefaultedAddress(int defaultedAddress) {
		this.defaultedAddress = defaultedAddress;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public float getFreight() {
		return freight;
	}
	public void setFreight(float freight) {
		this.freight = freight;
	}
}
