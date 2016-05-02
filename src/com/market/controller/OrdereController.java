package com.market.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Order;
import com.market.javabean.OrderBean;
import com.market.service.OrderService;

@Controller
public class OrdereController {
	@Resource(name = "orderServiceImpl")
	public OrderService orderService;

	/**
	 * 通过orderId查找订单信息
	 * @param orderId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleOrder")
	public Order findSingleOrder(@RequestParam int orderId) {

		Order order = orderService.findSingleOrder(orderId);
		return order;
	}

	/**
	 * 通过用户id查找订单信息
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllOrders")
	public List<OrderBean> findAllOrders(@RequestParam int userId) {
		List<OrderBean> orders = orderService.findAllOrders(userId);
		return orders;
	}
	/**
	 * 添加单个order
	 * @param addressId
	 * @param userId
	 * @param state
	 * @param orderTime
	 * @param deliverTime
	 * @param freight
	 * @param total
	 * @param remarks
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addSingleOrder")
	public Map<String, String> addSingleOrder(int addressId, int userId, int state, Date orderTime,
			Date deliverTime, float freight, float total, String remarks) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			orderService.addSingleOrder(addressId, userId, state, orderTime, deliverTime, freight, total, remarks);
		} catch (Exception e) {
			map.put("message", "addSingleOrderError");
			return map;
		}
		map.put("message", "addSingleOrderSuccess");
		return map;
	}
}
