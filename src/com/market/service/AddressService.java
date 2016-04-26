package com.market.service;

import java.util.List;

import com.market.javabean.AddressBean;

public interface AddressService {

	/**
	 * 根据用户id查找收货地址编号
	 * @param userId
	 * @return
	 */
	List<AddressBean> findAllAdress(int userId);
}
