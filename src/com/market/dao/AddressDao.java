package com.market.dao;

import java.util.List;

import com.market.javabean.AddressBean;

public interface AddressDao {

	/**
	 * 根据用户id查找收货地址
	 * @param userId
	 * @param addressId
	 * @return
	 */
	List<AddressBean> findAllAddress(int userId);
	/**
	 * 根据收货地址编号查找收货地址
	 * @param addressId
	 * @return
	 */
	AddressBean findSingleAddress(int addressId);
}
