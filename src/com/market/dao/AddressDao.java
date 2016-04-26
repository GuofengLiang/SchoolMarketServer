package com.market.dao;

import java.util.List;

import com.market.javabean.AddressBean;

public interface AddressDao {

	/**
	 * 根据用户id查找收货地址编号
	 * @param userId
	 * @return
	 */
	List<AddressBean> findAllAdress(int userId);
}
