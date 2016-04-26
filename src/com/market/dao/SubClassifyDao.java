package com.market.dao;

import java.util.List;
import java.util.Map;

import com.market.entity.MainClassify;
import com.market.entity.SubClassify;
import com.market.javabean.SubClassBean;
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
   List<SubClassBean> findAllSubClassifies();
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
	/**
	 * 查找所有mainclassify的数据
	 * @return
	 */
	List<MainClassify> findAllMainClassify();
	/**
	 * 查找所有大分类下的子分类
	 * @return
	 */
	List<Map<String,Object>> findAllClassify();
}
