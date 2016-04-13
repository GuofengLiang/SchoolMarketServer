package com.market.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.market.entity.Order;
import com.market.service.OrderService;

@Controller
public class OrdereController {
	@Resource(name="OrderServiceImpl")
	public OrderService orderService;
	
	@RequestMapping(value="/findSingleOrder")
	public Order findSingleOrder(@RequestParam int orderId){
		
		Order order = orderService.findSingleOrder(orderId);
		return order;
	}

}
