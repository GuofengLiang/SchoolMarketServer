package com.market.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 * 商品分类表
 * @author guofeng
 *
 */
@Entity
public class Classification {

	/**
	 * 分类id
	 */
	@Id
	private int classId;
	/**
	 * 食品分类
	 */
	private int foodclass;
	/**
	 * 细分
	 */
	private int subdivide;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="classification_id")
	private Set<Commodity> commodity=new HashSet<Commodity>();

	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getFoodclass() {
		return foodclass;
	}
	public void setFoodclass(int foodclass) {
		this.foodclass = foodclass;
	}
	public int getSubdivide() {
		return subdivide;
	}
	public void setSubdivide(int subdivide) {
		this.subdivide = subdivide;
	}
	public Set<Commodity> getCommodity() {
		return commodity;
	}
	public void setCommodity(Set<Commodity> commodity) {
		this.commodity = commodity;
	}
}
