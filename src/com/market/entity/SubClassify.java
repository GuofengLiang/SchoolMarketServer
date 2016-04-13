package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class SubClassify {
  /**
   * 商品次分类id
   */
  @Id
  private int subclassId;
  
  /**
   * 商品次分类名称
   */
  @Column(length=10,nullable=false)
  private String subclassName;
  /**
   * 商品主分类id
   */
  @ManyToOne(fetch = FetchType.EAGER,optional = false)
  @JoinColumn(name="mainclass_id")
  private MainClassify mainclassId;
public int getSubclassId() {
	return subclassId;
}
public void setSubclassId(int subclassId) {
	this.subclassId = subclassId;
}
public String getSubclassName() {
	return subclassName;
}
public void setSubclassName(String subclassName) {
	this.subclassName = subclassName;
}
public MainClassify getMainclassId() {
	return mainclassId;
}
public void setMainclassId(MainClassify mainclassId) {
	this.mainclassId = mainclassId;
}

}
