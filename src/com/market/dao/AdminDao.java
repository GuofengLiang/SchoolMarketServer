package com.market.dao;

import com.market.entity.Admin;

public interface AdminDao {
  Admin findSingleAdmin(String adminName);
}
