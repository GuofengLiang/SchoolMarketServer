package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Commodity;
import com.market.service.SupermarketService;

@Controller
public class SupermarketController {
 @Resource(name="supermarketServiceImpl")
 public SupermarketService supermarketService;
 @ResponseBody
 @RequestMapping(value="findAllCommodity")
 public List<Commodity> findAllCommodity(@RequestParam int supermarketId) {
		List<Commodity> commodities=supermarketService.findAllCommodity(supermarketId);
		return commodities;
	}
}
