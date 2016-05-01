package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.javabean.AddressBean;
import com.market.service.AddressService;

@Controller
public class AddressController {

	@Resource(name = "addressServiceImpl")
	public AddressService addressService;
	/**
	 * 根据用户id查找收货地址
	 */
	@ResponseBody
	@RequestMapping(value = "findAllAdress")
	public List<AddressBean> findAllAdress(int userId) {
		List<AddressBean> addressBean = addressService.findAllAddress(userId);
		return addressBean;
	}
	/**
	 * 根据收货地址编号查找收货地址
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleAddress")
	public AddressBean findSingleAddress(int addressId) {
		AddressBean addressBean = addressService.findSingleAddress(addressId);
		return addressBean;
	}
}
