package com.market.javabean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BuyCommBean {
	private int addressId;
	/**
	 * 下单时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date orderTime;
	
	/**
	 * 配送时间
	 */
	private String deliverTime;
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
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
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
