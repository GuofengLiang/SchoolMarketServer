package com.market.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单表
 * @author 
 *
 */
@Entity
@Table(name="orders")
public class Order {
	
	/**
	 * 订单id
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
	private int orderId;
	/**
	 * 收货地址编号
	 */
	@OneToOne( optional = false)
    @JoinColumn(name = "address_id",unique = true)
	private Address addressId;
	/**
	 * 用户id
	 */
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="user_id")
	private User user;
	/**
	 * 状态
	 */
	private int state;
	/**
	 * 下单时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date orderTime;
	/**
	 * 配送时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
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
	@Column(length=100)
	private String remarks;

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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
}
