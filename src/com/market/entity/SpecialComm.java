package com.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;
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
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "commodity_id",unique = true)
	private Commodity commodity;
	/**
	 * 超市id
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="supermarket_id")
	private Supermarket supermarket;
	/**
	 * 折扣
	 */
	private float discount;
	/**
	 * 折扣时间
	 */
	private DateTime specialTime;
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
	public DateTime getSpecialTime() {
		return specialTime;
	}
	public void setSpecialTime(DateTime specialTime) {
		this.specialTime = specialTime;
	}
}