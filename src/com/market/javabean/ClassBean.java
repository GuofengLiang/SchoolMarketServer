package com.market.javabean;

import com.market.entity.SubClassify;

public class ClassBean {
	/**
	 * 商品主分类id
	 */
	private int mainclassId;
	/**
	 * 商品主分类名称
	 */
	private String mainclassName;
	/**
	 * 商品次分类对象
	 */
	private SubClassify subClassify;

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
