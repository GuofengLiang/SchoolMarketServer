package com.market.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.market.dao.SubClassifyDao;
import com.market.entity.SubClassify;
import com.market.javabean.SubClassBean;
import com.market.javabean.SubClassifyBean;
import com.market.service.SubClassifyService;

@Service
public class SubClassifyServiceImpl implements SubClassifyService {
	@Resource(name="subClassifyDaoImpl")
	public SubClassifyDao subClassifyDao;

	/**
	 * 根据mainclassId查找subclass详情
	 * @param mainclassId
	 * @ return
	 */
	@Override
	public List<SubClassifyBean> findAllSubClassify(int mainclassId) {
		List<SubClassifyBean> subClassifies = subClassifyDao.findAllSubClassify(mainclassId);
		return subClassifies;
	}
	/**
    * 查询所有子分类的信息
    * @return
    */
	@Override
	public List<SubClassBean> findAllSubClassifies() {
		List<SubClassBean> subClass = subClassifyDao.findAllSubClassifies();
		return subClass;
	}
	/**
	 * 添加子分类
	 */
	@Override
	public void addSubClassify(String subclassName, int mainclassId) throws Exception {
		subClassifyDao.addSubClassify(subclassName, mainclassId);
	}
	/**
	 * 根据subclassId查找子分类信息
	 */
	@Override
	public SubClassify findSingleSubClassify(int subclassId) {
		SubClassify subClassify = subClassifyDao.findSingleSubClassify(subclassId);
		return subClassify;
	}
	/**
	 * 修改分类的信息
	 */
	@Override
	public void alterClassify(int subclassId, String subclassName, String mainclassName) throws Exception {
		subClassifyDao.alterClassify(subclassId, subclassName, mainclassName);
	//	return subClassify;
	}
	/**
	 * 查找所有主分类下的子分类的信息
	 */
	@Override
	public List<Map<String,Object>> findAllClassify() {
		List<Map<String,Object>> classlistBean = subClassifyDao.findAllClassify();
		return classlistBean;
	}
}
