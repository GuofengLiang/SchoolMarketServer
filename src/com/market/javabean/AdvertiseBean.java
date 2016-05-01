package com.market.javabean;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.market.entity.Supermarket;

public class AdvertiseBean {

	/**
	 * 广告id
	 */
	private int advertiseId;
	/**
	 * 超市id
	 */
	private Supermarket supermarket;
	/**
	 * 图片
	 */
	private String advertisePic;
	/**
	 * 链接内容
	 */
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
