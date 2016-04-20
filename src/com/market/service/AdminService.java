package com.market.service;

import com.market.entity.Admin;

/**
 * 根据管理员账户查询后台员
 * 
 * @author guofeng
 * 
 */
public interface AdminService {
	public Admin login(String adminName, String password);
}
