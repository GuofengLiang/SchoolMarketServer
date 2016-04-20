package com.market.dao;

import com.market.entity.Admin;

public interface AdminDao {
	/**
	 * 根据管理员账户查询后台员
	 * 
	 * @author guofeng
	 * 
	 */
	Admin findSingleAdmin(String adminName);
}
