package com.market.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;
/**
 * 订单表
 * @author 
 *
 */
@Entity
public class Order {
	
	/**
	 * 订单id
	 */
	@Id
	private int orderId;
	/**
	 * 收货地址编号
	 */
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id",unique = true)
	private Address addressId;
	/**
	 * 用户id
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="user_id")
	private User user;
	/**
	 * 状态
	 */
	private int state;
	/**
	 * 下单时间
	 */
	private DateTime orderTime;
	/**
	 * 配送时间
	 */
	private DateTime deliverTime;
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
    
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
	private Set<OrderComm> orderComm=new HashSet<OrderComm>();
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
	public DateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(DateTime orderTime) {
		this.orderTime = orderTime;
	}
	public DateTime getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(DateTime deliverTime) {
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
	public Set<OrderComm> getOrderComm() {
		return orderComm;
	}
	public void setOrderComm(Set<OrderComm> orderComm) {
		this.orderComm = orderComm;
	}
}
