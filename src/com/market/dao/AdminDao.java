package com.market.dao;

import com.market.entity.Admin;

public interface AdminDao {
  Admin findSingleUser(String adminname);
}
