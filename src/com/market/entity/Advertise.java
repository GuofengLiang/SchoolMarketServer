package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * 广告表
 * @autho
 *
 */
@Entity
public class Advertise {

	/**
	 * 广告id
	 */
	@Id
	private int advertiseId;
	/**
	 * 超市id
	 */
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="supermarket_id")
	private Supermarket supermarket;
	/**
	 * 图片
	 */
	@Column(length=100)
	private String advertisePic;
	/**
	 * 链接内容
	 */
	@Column(length=100)
	private String linkContent;
	
	
	public int getAdvertiseId() {
		return advertiseId;
	}
	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
	}
	public Supermarket getSupermarket() {
		return supermarket;
	}
	public void setSupermarket(Supermarket supermarket) {
		this.supermarket = supermarket;
	}
	public String getAdvertisePic() {
		return advertisePic;
	}
	public void setAdvertisePic(String advertisePic) {
		this.advertisePic = advertisePic;
	}
	public String getLinkContent() {
		return linkContent;
	}
	public void setLinkContent(String linkContent) {
		this.linkContent = linkContent;
	}
}
