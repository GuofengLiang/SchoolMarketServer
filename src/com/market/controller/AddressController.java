package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Address;
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
	public Map<String, Object> findAllAdress(@RequestParam int userId) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<AddressBean> addressBean;
		try {
			addressBean = addressService.findAllAddress(userId);
		} catch (Exception e) {
			map.put("message", "findDefaultedAddressError");
			return map;
		}
		map.put("message", addressBean);
		return map;
	}
	/**
	 * 根据收货地址编号查找收货地址
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleAddress")
	public AddressBean findSingleAddress(@RequestParam int addressId) {
		AddressBean addressBean = addressService.findSingleAddress(addressId);
		return addressBean;
	}
	/**
	 * 添加收货地址
	 * @param userId
	 * @param addressDetail
	 * @param consignee
	 * @param phone
	 * @param defaultedAddress
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addSingleAddress")
	public Map<String, String> addSingleAddress(int userId, String addressDetail, String consignee, String phone, int defaultedAddress) {
		Map<String,String> map=new HashMap<String,String>();
		try {
				addressService.addSingleAddress(userId, addressDetail, consignee, phone, defaultedAddress);

		} catch (Exception e) {
			map.put("message", "addSingleAddressError");
			return map;
		}
		map.put("message", "addSingleAddressSuccess");
		return map;
	}
	/**
	 * 查找默认地址
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findDefaultedAddress")
	public  Map<String, Object> findDefaultedAddress(@RequestParam int userId) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<AddressBean> addressBean;
		try {
			addressBean = addressService.findDefaultedAddress(userId);
		} catch (Exception e) {
			map.put("message", "findDefaultedAddressError");
			return map;
		}
		map.put("message", addressBean);
		return map;
	}
	/**
	 * 修改收货地址
	 * @param userId
	 * @param addressDetail
	 * @param consignee
	 * @param phone
	 * @param defaultedAddress
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "alterAddress")
	public Map<String, String> alterAddress(int addressId, String addressDetail, String consignee, String phone, int defaultedAddress) {
		Map<String,String> map=new HashMap<String,String>();
		try {
			AddressBean addressBean = addressService.findSingleAddress(addressId);
			addressService.alterAddress(addressId, addressDetail, consignee, phone, defaultedAddress);
			if(addressBean.getDefaultedAddress() == 1 && defaultedAddress == 0) {
				map.put("message", "donotAlterError");
				return map;	
			}
		} catch (Exception e) {
			map.put("message", "alterAddressError");
			return map;
		}
		map.put("message", "alterAddressSuccess");
		return map;
	}
	/**
	 * 删除收货地址
	 * @param addressId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteAddress")
	public Map<String, String> deleteAddress(int addressId) {
		Map<String,String> map=new HashMap<String,String>();
		try {
			AddressBean addressBean = addressService.findSingleAddress(addressId);
			if(addressBean.getDefaultedAddress() == 1) {
				map.put("message", "donotDeleteError");
				return map;	
			}
			addressService.deleteAddress(addressId);
		} catch (Exception e) {
			map.put("message", "deleteAddressError");
			return map;
		}
		map.put("message", "deleteAddressSuccess");
		return map;
	}
}
