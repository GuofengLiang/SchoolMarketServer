package com.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
/**
 * 商品表
 * @author guofeng
 *
 */
@Entity
public class Commodity {

	/**
	 * 商品id
	 */
	@Id
	private int commodityId;
	/**
	 * 商品名称
	 */
	@Column(length=20)
	private String commName;
	/**
	 * 超市id
	 */
//	@ManyToOne(fetch = FetchType.EAGER,optional = false)
//	@JoinColumn(name="supermarket_id")
//	private Supermarket supermarket;
	/**
	 * 分类id
	 */
//	@ManyToOne(fetch = FetchType.EAGER,optional = false)
//	@JoinColumn(name="classification_id")
//	private Classification classification;
	/**
	 * 图片
	 */
	@Column(length=100)
	private String picture;
	/**
	 * 价格
	 */
	private float price;
	/**
	 * 销量
	 */
	private int sales;
	/**
	 * 规格
	 */
	@Column(length=10)
	private String spercification;
	/**
	 * 描述
	 */
	@Column(length=10)
	private String describes;
	/**
	 * 库存
	 */
	private int stock;
	/**
	 * 购物车
	 */
//	@OneToOne(optional = true, mappedBy="commodity")
//	private ShopCart shopCart;
//	
//	@OneToOne(optional = true, mappedBy="commodity") 
//	private OrderComm orderComm;
//	
//	@OneToOne(optional = true, mappedBy="commodity") 
//	private SpecialComm specialComm;
//	
//	@OneToOne(optional = true, mappedBy="commodity") 
//	private Recommend recommend;
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
//	public Supermarket getSupermarket() {
//		return supermarket;
//	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
//	public void setSupermarket(Supermarket supermarket) {
//		this.supermarket = supermarket;
//	}
//	public Classification getClassification() {
//		return classification;
//	}
//	public void setClassification(Classification classification) {
//		this.classification = classification;
//	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getSpercification() {
		return spercification;
	}
	public void setSpercification(String spercification) {
		this.spercification = spercification;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
//	public ShopCart getShopCart() {
//		return shopCart;
//	}
//	public void setShopCart(ShopCart shopCart) {
//		this.shopCart = shopCart;
//	}
//	public OrderComm getOrderComm() {
//		return orderComm;
//	}
//	public void setOrderComm(OrderComm orderComm) {
//		this.orderComm = orderComm;
//	}
//	public SpecialComm getSpecialComm() {
//		return specialComm;
//	}
//	public void setSpecialComm(SpecialComm specialComm) {
//		this.specialComm = specialComm;
//	}
//	public Recommend getRecommend() {
//		return recommend;
//	}
//	public void setRecommend(Recommend recommend) {
//		this.recommend = recommend;
//	}
//	
}
