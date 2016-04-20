package com.market.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 超市表
 * 
 * @author guofeng
 * 
 */
@Entity
public class Supermarket {

	/**
	 * 超市id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int supermarketId;
	/**
	 * 超市名称
	 */
	@Column(length = 20)
	private String supermarketName;
	/**
	 * 地区
	 */
	@Column(length = 20)
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
	@Column(length = 100)
	private String notice;

	@JoinColumn(name = "supermarket_id")
	@OneToMany(fetch = FetchType.LAZY)
	@OrderBy("commodityId desc")
	private Set<Commodity> commodity = new HashSet<Commodity>();

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

	public Set<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(Set<Commodity> commodity) {
		this.commodity = commodity;
	}
}
