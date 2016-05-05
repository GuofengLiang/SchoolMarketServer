package com.market.javabean;

import java.util.Date;
import java.util.List;

public class BuyCommBean {
	private int addressId;
	/**
	 * 下单时间
	 */
	private Date orderTime;
	
	/**
	 * 配送时间
	 */
	private Date deliverTime;
	/**
	 * 运费
	 */
	private float freight;
	/**
	 * 总额
	 */
	private float total;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 用户id
	 */
	private int userId;
	private List<CommListBean> commListBeans;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public float getFreight() {
		return freight;
	}
	public void setFreight(float freight) {
		this.freight = freight;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<CommListBean> getCommListBeans() {
		return commListBeans;
	}
	public void setCommListBeans(List<CommListBean> commListBeans) {
		this.commListBeans = commListBeans;
	}
	@Override
	public String toString() {
		return "BuyCommBean [addressId=" + addressId + ", orderTime=" + orderTime + ", deliverTime=" + deliverTime
				+ ", freight=" + freight + ", total=" + total + ", remarks=" + remarks + ", userId=" + userId
				+ ", commListBeans=" + commListBeans + "]";
	}
}
