package com.market.javabean;

public class CommodityBean {

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
	 * 购物车
	 */
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
}
