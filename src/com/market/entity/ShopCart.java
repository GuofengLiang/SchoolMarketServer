package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 购物车商品表
 * 
 * @author
 * 
 */
@Entity
public class ShopCart {

	/**
	 * 购物车商品id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int shopCartId;
	/**
	 * 用户id
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	/**
	 * 商品id
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "commodity_id")
	private Commodity commodity;
	/**
	 * 数量
	 */
	private int number;

	public int getShopCartId() {
		return shopCartId;
	}

	public void setShopCartId(int shopCartId) {
		this.shopCartId = shopCartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
