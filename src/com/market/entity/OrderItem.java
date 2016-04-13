package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 * 订单商品表
 * @author 
 *
 */
@Entity
public class OrderItem {

	/**
	 * 订单商品id
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
	private int orderCommId;
	/**
	 * 商品id
	 */
	@OneToOne( optional = false)
	@JoinColumn(name = "commodity_id",unique = true)
	private Commodity commodity;
	/**
	 * 订单id
	 */
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="order_id")
	private Order order;
	/**
	 * 数量
	 */
	private int orderNumber;
	public int getOrderCommId() {
		return orderCommId;
	}
	public void setOrderCommId(int orderCommId) {
		this.orderCommId = orderCommId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
}
