package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.market.dao.SubClassifyDao;
import com.market.entity.SubClassify;
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
	@Override
	/**
    * 查询所有子分类的信息
    * @return
    */
	public List<SubClassify> findAllSubClassifies() {
		List<SubClassify> subClass = subClassifyDao.findAllSubClassifies();
		return subClass;
	}
	/**
	 * 添加子分类
	 */
	public void addSubClassify(String subclassName, int mainclassId) throws Exception {
		subClassifyDao.addSubClassify(subclassName, mainclassId);
	}
}
