package com.market.javabean;

import java.util.Date;

import com.market.entity.Address;

public class AddOrderBean {

		/**
		 * 订单id
		 */
		private int orderId;
		/**
		 * 收货地址编号
		 */
		private Address addressId;
		/**
		 * 用户id
		private User user;
		/**
		 * 状态
		 */
		private int state;
		/**
		 * 下单时间
		 */
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
		//这是收货地址的信息
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
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public Address getAddressId() {
			return addressId;
		}
		public void setAddressId(Address addressId) {
			this.addressId = addressId;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
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
}
