package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MainClassify {
  /**
   * 商品主分类id
   */
  @Id
  private int mainclassId;
  @Column(length=10,nullable=false)
  /**
   * 商品主分类名称
   */
  private String mainclassName;
public int getMainclassId() {
	return mainclassId;
}
public void setMainclassId(int mainclassId) {
	this.mainclassId = mainclassId;
}
public String getMainclassName() {
	return mainclassName;
}
public void setMainclassName(String mainclassName) {
	this.mainclassName = mainclassName;
}

}
