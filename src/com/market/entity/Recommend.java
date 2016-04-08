package com.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 * 推荐商品表
 * @author 
 *
 */
@Entity
public class Recommend {

	/**
	 * 推荐商品
	 */
	@Id
	private int remommendId;
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
	public int getRemommendId() {
		return remommendId;
	}
	public void setRemommendId(int remommendId) {
		this.remommendId = remommendId;
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
}
