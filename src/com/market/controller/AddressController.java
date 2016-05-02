package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@ResponseBody
	@RequestMapping(value = "addSingleAddress")
	public Map<String, String> addSingleAddress(int userId, String addressDetail, String consignee, String phone, int defaultedAddress) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			addressService.addSingleAddress(userId, addressDetail, consignee, phone, defaultedAddress);
		} catch (Exception e) {
			map.put("message", "addSingleAddressError");
			return map;
		}
		map.put("message", "addSingleAddressSuccess");
		return map;
	}
}
