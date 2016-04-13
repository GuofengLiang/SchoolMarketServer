package com.market.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	 @ResponseBody
	 @RequestMapping(value="addSingleCommodity")
	 public Map<String,String> addSingleCommodity(
		String mainclassName,
        String subclassName,
		String commName,
		String picture,
		float price,
		String spercification,
		String describes,
		int stock, 
		float discount,
		int type,
		HttpSession session) {
		 Map<String,String> map=new HashMap<String, String>();
	    Date specialTime=new Date();
		int supermarketId=(Integer) session.getAttribute("supermarketId");   
		try{
			commodityService.addSingleCommodity(mainclassName, subclassName, commName, picture, price, spercification, describes, stock, discount, specialTime, type, supermarketId);
		}catch(Exception e){
			 map.put("message", "addCommodityError");
			 return map;
		}
		 map.put("message", "addCommoditySuccess");
		 return map;
		}
}
