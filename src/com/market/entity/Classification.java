package com.market.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	 * 商品主分类id
	 */
	@OneToOne( optional = false)
    @JoinColumn(name = "mainclass_id",unique = true)
	private MainClassify mainclassId;
	/**
	 * 商品次分类id
	 */
	@OneToOne( optional = false)
    @JoinColumn(name = "subclass_id",unique = true)
	private SubClassify subclassId;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="classification_id")
	private Set<Commodity> commodity=new HashSet<Commodity>();

	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Set<Commodity> getCommodity() {
		return commodity;
	}
	public void setCommodity(Set<Commodity> commodity) {
		this.commodity = commodity;
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
}
