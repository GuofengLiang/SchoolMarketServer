package com.market.javabean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderCommBean {
	/**
	 * 商品id
	 */
	private int commodityId;
	/**
	 * 商品名称
	 */
	private String commName;
	/**
	 * 图片
	 */
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
	private String spercification;
	/**
	 * 描述
	 */
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
	 * 特价时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date specialTime;
	/**
	 * 商品类型
	 */
	private String type;
	/**
	 * 主分类id
	 */
	private int mainclassId;
	/**
	 * 主分类名
	 * @return
	 */
	private String mainclassName;
	/**
	 * 次分类id
	 */
	private int subclassId;
	/**
	 * 次分类名
	 * @return
	 */
	private String subclassName;
	/**
	 * 商品数量
	 */
	private int orderNumber;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMainclassId() {
		return mainclassId;
	}
	public void setMainclassId(int mainclassId) {
		this.mainclassId = mainclassId;
	}
	public String getMainclassName() {
		return mainclassName;
	}
	public void setMainclassName(String mainclassName) {
		this.mainclassName = mainclassName;
	}
	public int getSubclassId() {
		return subclassId;
	}
	public void setSubclassId(int subclassId) {
		this.subclassId = subclassId;
	}
	public String getSubclassName() {
		return subclassName;
	}
	public void setSubclassName(String subclassName) {
		this.subclassName = subclassName;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
}
