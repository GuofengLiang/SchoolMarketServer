package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.entity.Commodity;
import com.market.javabean.CommodityBean;
import com.market.service.CommodityService;
import com.market.utils.Format;

@Controller
public class CommodityController {

	@Resource(name = "commodityServiceImpl")
	public CommodityService commodityService;

	/**
	 * 根据commodityId来查询该超市的相关信息
	 * 
	 * @param commodityId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleComm")
	public CommodityBean findSingleComm(@RequestParam int commodityId) {
		CommodityBean commodityBean = commodityService.findSingleComm(commodityId);
		return commodityBean;
	}

	/**
	 * 添加单个商品
	 * @param mainclassName
	 * @param subclassName
	 * @param commName
	 * @param price
	 * @param spercification
	 * @param describes
	 * @param stock
	 * @param specialTime
	 * @param discount
	 * @param type
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addSingleCommodity")
	public Map<String, String> addSingleCommodity(String mainclassName,
			String subclassName, String commName, float price,
			String spercification, String describes, int stock,
			String specialTime, float discount, String type,
			HttpSession session, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		int supermarketId = (Integer) session.getAttribute("supermarketId");
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		int mainclassId=Integer.parseInt(mainclassName);
		int subclassId=Integer.parseInt(subclassName);
		try {
			commodityService.addSingleCommodity(mainclassId, subclassId,
					commName, price, spercification, describes, stock,
					discount, Format.string2Date(specialTime), type,
					supermarketId, mRequest);
		} catch (Exception e) {
			map.put("message", "addCommodityError");
			return map;
		}
		map.put("message", "addCommoditySuccess");
		return map;
	}
	/**
	 * 根据商品类型type查找商品
	 */
	@ResponseBody
	@RequestMapping(value = "findAllCommByType")
	public List<CommodityBean> findAllCommByType(String type) {
		List<CommodityBean> commYype = commodityService.findAllCommByType(type);
		return commYype;
	}
	/**
	 * 根据超市id和主分类id查找商品
	 */
	@ResponseBody
	@RequestMapping(value = "findAllCommByMclass")
	public Map<String, String> findAllCommByMclass(@RequestParam int supermartketId, int mainclassId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			List<Commodity> commodityBean = commodityService.findAllCommByMclass(supermartketId, mainclassId);
		} catch (Exception e) {
			map.put("message", "findAllCommByMclassError");
			return map;
		}
		map.put("message", "findAllCommByMclassSuccess");
		return map;
	}
	/**
	 * 根据mainclassId来查询该分类下商品的相关信息
	 */
	@ResponseBody
	@RequestMapping(value = "findAllCommByMainId")
	public List<CommodityBean> findAllCommByMainId(@RequestParam int mainclassId) {
		List<CommodityBean> commodityBean = commodityService.findAllCommByMainId(mainclassId);
		return commodityBean;
	}
	/**
	 * 查找6个热卖商品
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findSixCommBySales")
	public List<CommodityBean> findSixCommBySales() {
		List<CommodityBean> commodityListBean = commodityService.findSixCommBySales();
		return commodityListBean;
	}
	/**
	 * 查找热卖商品和特价商品
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findSaleAndSpecialComm")
	public List<Map<String, Object>> findSaleAndSpecialComm() {
		List<Map<String, Object>> commodities = commodityService.findSaleAndSpecialComm();
		return commodities;
	}
	/**
	 * 查找热卖商品和特价商品
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "fuzzySearchComm")
	public List<Commodity> fuzzySearchComm() {
		List<Commodity> Commodity = commodityService.fuzzySearchComm();
		return Commodity;
	}
}
