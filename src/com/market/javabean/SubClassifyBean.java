package com.market.javabean;

public class SubClassifyBean {
	/**
	 * 商品次分类id
	 */
	private int subclassId;

	/**
	 * 商品次分类名称
	 */
	private String subclassName;
	/**
	 * 商品主分类id
	 */

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
}
