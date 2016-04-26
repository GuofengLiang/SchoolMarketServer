package com.market.controller;

import java.util.List;

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

	@ResponseBody
	@RequestMapping(value = "findSingleOrder")
	public Order findSingleOrder(@RequestParam int orderId) {

		Order order = orderService.findSingleOrder(orderId);
		return order;
	}

	@ResponseBody
	@RequestMapping(value = "findAllOrders")
	public List<OrderBean> findAllOrders(@RequestParam int userId) {
		List<OrderBean> orders = orderService.findAllOrders(userId);
		return orders;
	}
}
