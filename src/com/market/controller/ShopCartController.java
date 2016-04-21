package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.ShopCart;
import com.market.entity.User;
import com.market.service.ShopCartService;

@Controller
public class ShopCartController {
	@Resource(name = "shopCartServiceImpi")
	public ShopCartService shopCartService;
	/**
	 * 通过用户id查找购物车详情
	 * @param userId
	 * @ return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllShopCarts")
	public List<ShopCart> findAllShopCarts(@RequestParam int userId) {
		 List<ShopCart> shopCarts = shopCartService.findAllShopCarts(userId);
		 return shopCarts;
	}
}
