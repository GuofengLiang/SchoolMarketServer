package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.ClassificationDao;
import com.market.entity.Classification;
import com.market.entity.Commodity;
import com.market.service.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService {
	@Resource(name="ClassificationDaoImpl")
	public ClassificationDao classificationDao;

	@Override
	public List<Commodity> findAllCommodity(int classId) {
		
		List<Commodity> commodities = classificationDao.findAllCommodity(classId);
		return commodities;
	}

	@Override
	public Classification findSingleClass(int classId) {
		
		Classification classification = classificationDao.findSingleClass(classId);
		return classification;
	}

}
