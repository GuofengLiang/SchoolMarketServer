package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.SubClassifyDao;
import com.market.entity.SubClassify;
import com.market.javabean.SubClassifyBean;
import com.market.service.SubClassifyService;

@Service
public class SubClassifyServiceImpl implements SubClassifyService {
	@Resource(name="subClassifyDaoImpl")
	public SubClassifyDao subClassifyDao;

	@Override
	public List<SubClassifyBean> findAllSubClassify(int mainclassId) {
		List<SubClassifyBean> subClassifies = subClassifyDao.findAllSubClassify(mainclassId);
		return subClassifies;
	}

}
