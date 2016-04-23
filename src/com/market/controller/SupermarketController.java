package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
import com.market.javabean.SupermarketBean;
import com.market.service.SupermarketService;

@Controller
public class SupermarketController {
	@Resource(name = "supermarketServiceImpl")
	public SupermarketService supermarketService;

	/**
	 * 根据超市id来查询所有的商品
	 * 
	 * @param supermarketId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllCommodity")
	public Map<String,List<CommodityBean>> findAllCommodity(@RequestParam int supermarketId) {
		Map<String,List<CommodityBean>> map=new HashMap<String,List<CommodityBean>>();
		try{
			List<CommodityBean> commodities = supermarketService.findAllCommodity(supermarketId);
			map.put("data", commodities);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "adminFindAllCommodity")
	public Map<String,List<CommodityBean>> adminFindAllCommodity(HttpSession session) {
		int supermarketId = (Integer) session.getAttribute("supermarketId");
		Map<String,List<CommodityBean>> map=new HashMap<String,List<CommodityBean>>();
		try{
			List<CommodityBean> commodities = supermarketService.findAllCommodity(supermarketId);
			map.put("data", commodities);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据supermarketId来查询该超市的相关信息
	 * 
	 * @param supermarketId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleSuper")
	public SupermarketBean findSingleSuper(@RequestParam int supermarketId) {
		SupermarketBean supermarketBean = supermarketService
				.findSingleSuper(supermarketId);
		return supermarketBean;
	}

}
