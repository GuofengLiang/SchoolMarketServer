package com.market.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 超市表
 * @author guofeng
 *
 */
@Entity
public class Supermarket {

	/**
	 * 超市id
	 */
	@Id
	private int supermarketId;
	/**
	 * 超市名称
	 */
	@Column(length=20)
	private String supermarketName;
	/**
	 * 地区
	 */
	@Column(length=20)
	private String superRegion;
	/**
	 * 营业时间
	 */
	private Date datetime;
	/**
	 * 公告
	 */
	@Column(length=100)
	private String notice;
	
	@OneToMany( fetch = FetchType.LAZY,mappedBy = "supermarket")
	private Set<Commodity> commodity=new HashSet<Commodity>();
	
	@OneToMany( fetch = FetchType.LAZY,mappedBy = "supermarket")
	private Set<SpecialComm> specialComm=new HashSet<SpecialComm>();
	
	@OneToMany( fetch = FetchType.LAZY,mappedBy = "supermarket")
	private Set<Advertise> advertise=new HashSet<Advertise>();
	
	@OneToMany( fetch = FetchType.LAZY,mappedBy = "supermarket")
	private Set<Recommend> recommend=new HashSet<Recommend>();
	
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
	public Set<SpecialComm> getSpecialComm() {
		return specialComm;
	}
	public void setSpecialComm(Set<SpecialComm> specialComm) {
		this.specialComm = specialComm;
	}
	public Set<Advertise> getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Set<Advertise> advertise) {
		this.advertise = advertise;
	}
	public Set<Recommend> getRecommend() {
		return recommend;
	}
	public void setRecommend(Set<Recommend> recommend) {
		this.recommend = recommend;
	}
	
}
