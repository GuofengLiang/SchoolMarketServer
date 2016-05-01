package com.market.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 商品表
 * 
 * @author guofeng
 * 
 */
@Entity
public class Commodity {

	/**
	 * 商品id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int commodityId;
	/**
	 * 商品名称
	 */
	@Column(length = 20)
	private String commName;
	/**
	 * 图片
	 */
	@Column(length = 100)
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
	@Column(length = 10)
	private String spercification;
	/**
	 * 描述
	 */
	@Column(length = 10)
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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date specialTime;

	/**
	 * 商品类别 0表示普通商品，1表示特价商品 2表示推荐商品
	 */
	private String type;
	/**
	 * 商品主分类id
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "mainclass_id")
	private MainClassify mainclassId;
	/**
	 * 商品次分类id
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "subclass_id")
	private SubClassify subclassId;

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

	public MainClassify getMainclassId() {
		return mainclassId;
	}

	public void setMainclassId(MainClassify mainclassId) {
		this.mainclassId = mainclassId;
	}

	public SubClassify getSubclassId() {
		return subclassId;
	}

	public void setSubclassId(SubClassify subclassId) {
		this.subclassId = subclassId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
