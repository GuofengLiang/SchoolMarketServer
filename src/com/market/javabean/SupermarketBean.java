package com.market.javabean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SupermarketBean {
	/**
	 * 超市id
	 */
	private int supermarketId;
	/**
	 * 超市名称
	 */
	private String supermarketName;
	/**
	 * 地区
	 */
	private String superRegion;
	/**
	 * 营业时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date datetime;
	/**
	 * 公告
	 */
	private String notice;

	public int getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(int supermarketId) {
		this.supermarketId = supermarketId;
	}

	public String getSupermarketName() {
		return supermarketName;
	}

	public void setSupermarketName(String supermarketName) {
		this.supermarketName = supermarketName;
	}

	public String getSuperRegion() {
		return superRegion;
	}

	public void setSuperRegion(String superRegion) {
		this.superRegion = superRegion;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}
}
