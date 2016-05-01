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
}
