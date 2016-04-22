package com.market.service;

import java.util.List;

import com.market.entity.SubClassify;
import com.market.javabean.SubClassBean;
import com.market.javabean.SubClassifyBean;

public interface SubClassifyService {

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
    */
   void addSubClassify(String subclassName, int mainclassId) throws Exception;
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
   void alterClassify(int subclassId, String subclassName, String mainclassName) throws Exception;
}
