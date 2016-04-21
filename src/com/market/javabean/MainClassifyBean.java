package com.market.javabean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MainClassifyBean {

	/**
	 * 商品主分类id
	 */
	private int mainclassId;
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
