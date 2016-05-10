package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.dao.AddressDao;
import com.market.entity.Address;
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
	/**
	 * 根据用户id查找默认地址
	 */
	@Override
	public List<AddressBean> findDefaultedAddress(int userId) {
		List<AddressBean> addressBean = addressDao.findDefaultedAddress(userId);
		return addressBean;
	}
	/**
	 * 添加单个收货地址
	 */
	@Override
	public void addSingleAddress(int userId, String addressDetail, String consignee, String phone,
			int defaultedAddress) {
		addressDao.addSingleAddress(userId, addressDetail, consignee, phone, defaultedAddress);
		
	}
	/**
	 * 修改收货地址
	 */
	@Override
	public void alterAddress(int addressId, String addressDetail, String consignee, String phone,
			int defaultedAddress) {
		addressDao.alterAddress(addressId, addressDetail, consignee, phone, defaultedAddress);
		
	}
	/**
	 * 删除收货地址
	 */
	@Override
	public void deleteAddress(int addressId) {
		addressDao.deleteAddress(addressId);
		
	}

}
