package com.market.service;

import java.util.List;

import com.market.javabean.AddressBean;

public interface AddressService {

	/**
	 * 根据用户id查找收货地址
	 * @param userId
	 * @return
	 */
	List<AddressBean> findAllAddress(int userId);
	/**
	 * 根据收货地址编号查找收货地址
	 * @param addressId
	 * @return
	 */
	AddressBean findSingleAddress(int addressId);
	/**
	 * 添加单个收货地址
	 * @param userId
	 * @param addressDetail
	 * @param consignee
	 * @param phone
	 */
	void addSingleAddress(int userId, String addressDetail, String consignee, String phone, int defaultedAddress);
}
