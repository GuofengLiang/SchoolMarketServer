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
	public void delectClassify(int mainclassId) {
		mainClassifyDao.delectClassify(mainclassId);
		
	}

	/**
	 * 添加主分类
	 */
	@Override
	public void addMainClassify(String mainclassName) {
		mainClassifyDao.addMainClassify(mainclassName);
	}
	/**
	 * 修改主分类
	 */
	@Override
	public void alterMainClassify(int mainclassId, String mainclassName) throws Exception {
		mainClassifyDao.alterMainClassify(mainclassId, mainclassName);
	}
	/**
	 * 根据mainclassId来查询该主分类的信息
	 */
	@Override
	public MainClassify findSingleMainClassify(int mainclassId) {
		MainClassify mainClassify = mainClassifyDao.findSingleMainClassify(mainclassId);
		return mainClassify;
	}
}
