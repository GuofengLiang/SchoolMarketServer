package com.market.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 * 特价商品表
 * @author
 *
 */
@Entity
public class SpecialComm {

	/**
	 * 特价商品id
	 */
	@Id
	private int specialCommId;
	/**
	 * 商品id
	 */
	@OneToOne( optional = false)
	@JoinColumn(name = "commodity_id",unique = true)
	private Commodity commodity;
	/**
	 * 超市id
	 */
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="supermarket_id")
	private Supermarket supermarket;
	/**
	 * 折扣
	 */
	private float discount;
	/**
	 * 折扣时间
	 */
	private Date specialTime;
	public int getSpecialCommId() {
		return specialCommId;
	}
	public void setSpecialCommId(int specialCommId) {
		this.specialCommId = specialCommId;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public Supermarket getSupermarket() {
		return supermarket;
	}
	public void setSupermarket(Supermarket supermarket) {
		this.supermarket = supermarket;
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
}
