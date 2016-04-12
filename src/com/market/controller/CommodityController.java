package com.market.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Commodity;
import com.market.service.CommodityService;

@Controller
public class CommodityController {

	@Resource(name="commodityServiceImpl")
	 public CommodityService commodityService;
	/**
	  * 根据commodityId来查询该超市的相关信息
	  * 
	  * @param commodityId
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value="findSingleComm")
	public Commodity findSingleComm(@RequestParam int commodityId) {
		Commodity commodity=commodityService.findSingleComm(commodityId);
		return commodity;
	}
}
