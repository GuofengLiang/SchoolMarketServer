package com.market.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.market.dao.AdminDao;
import com.market.entity.Admin;
import com.market.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource(name="adminDaoImpl")
	AdminDao adminDao;
	
	public Admin login(String adminName ,String password) {
				
		Admin admin=adminDao.findSingleAdmin(adminName);
	    return admin;

	}
}
