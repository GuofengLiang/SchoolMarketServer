package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.MainClassifyDao;
import com.market.entity.MainClassify;
import com.market.service.MainClassifyService;

@Service
public class MainClassifyServiceImpl implements MainClassifyService {
	@Resource(name="mainClassifyDaoImpl")
	public MainClassifyDao mainClassifyDao;

	@Override
	public List<MainClassify> findAllMainClassify() {
		List<MainClassify> mainClassifies = mainClassifyDao.findAllMainClassify();
		return mainClassifies;
	}

	@Override
	public void addMainClassify(String mainclassName) {
		mainClassifyDao.addMainClassify(mainclassName);
	}
}
