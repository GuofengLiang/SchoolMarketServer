package com.market.dao;

import java.util.List;

import com.market.entity.MainClassify;
import com.market.entity.SubClassify;
import com.market.javabean.SubClassifyBean;

public interface SubClassifyDao {
	/**
	 * 根据mainclassId获取大分类的子类
	 * @param mainclassId
	 * @return
	 */
   List<SubClassifyBean> findAllSubClassify(int mainclassId);
   /**
    * 查询所有子分类的信息
    * @return
    */
   List<SubClassify> findAllSubClassifies();
   /**
    * 添加子分类
    * @param subclassId
    * @param subclassName
    */
   void addSubClassify(String subclassName, int mainclassId);
   /**
    * 根据subclassId查找子分类信息
    * @param subclassId
    */
   SubClassify findSingleSubClassify(int subclassId);
   /**
    * 修改分类的信息
    * @param subclassId
    * @param subclassName
    */
   void alterClassify(int subclassId, String subclassName, String mainclassName);
	/**
	 * 根据mainclassId来查询该主分类的信息
	 */
	MainClassify findSingleMainClassify(int mainclassId);
}
