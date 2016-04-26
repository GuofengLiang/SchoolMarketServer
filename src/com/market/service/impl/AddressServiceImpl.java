package com.market.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.javabean.AddressBean;
import com.market.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Resource(addressDaoImpl)
	/**
	 * 根据用户id查找收货地址
	 */
	@Override
	public List<AddressBean> findAllAdress(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
