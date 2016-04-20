package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.SubClassifyDao;
import com.market.entity.SubClassify;
import com.market.service.SubClassifyService;

@Service
public class SubClassifyServiceImpl implements SubClassifyService {
	@Resource(name="SubClassifyDaoImpl")
	public SubClassifyDao subClassifyDao;

	@Override
	public List<SubClassify> findAllSubClassify(int mainclassId) {
		List<SubClassify> subClassifies = subClassifyDao.findAllSubClassify(mainclassId);
		return subClassifies;
	}

}
