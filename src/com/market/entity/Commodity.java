package com.market.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	 * 折扣
	 */
	private float discount;
	/**
	 * 折扣时间
	 */
	private Date specialTime;
	/**
	 * 商品类别  0表示普通商品，1表示特价商品  2表示推荐商品
	 */
	private int type;
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
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
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Date getSpecialTime() {
		return specialTime;
	}
	public void setSpecialTime(Date specialTime) {
		this.specialTime = specialTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
