package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.AddressDao;
import com.market.javabean.AddressBean;
import com.market.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Resource(name = "addressDaoImpl")
	public AddressDao addressDao;
	/**
	 * 根据用户id查找收货地址
	 */
	@Override
	public List<AddressBean> findAllAddress(int userId) {
		List<AddressBean> addressBean = addressDao.findAllAddress(userId);
		return addressBean;
	}
	/**
	 * 根据收货地址编号查找收货地址
	 */
	@Override
	public AddressBean findSingleAddress(int addressId) {
		AddressBean addressBean = addressDao.findSingleAddress(addressId);
		return addressBean;
	}

}
