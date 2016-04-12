package com.market.dao;

import com.market.entity.Admin;
/**
 * 根据管理员账户查询后台员
 * @author guofeng
 *
 */
public interface AdminDao {
  Admin findSingleAdmin(String adminName);
}
