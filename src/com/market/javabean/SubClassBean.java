package com.market.javabean;

import com.market.entity.SubClassify;

public class SubClassBean {

	/**
	 * 商品主分类id
	 */
	private int mainclassId;
	/**
	 * 商品主分类名称
	 */
	private String mainclassName;
	/**
	 * 商品次分类id
	 */
	private int subclassId;
	/**
	 * 商品子分类名称
	 */
	private String subclassName;
	

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
