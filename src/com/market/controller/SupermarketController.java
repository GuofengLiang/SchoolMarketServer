package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Commodity;
import com.market.javabean.SupermarketBean;
import com.market.service.SupermarketService;

@Controller
public class SupermarketController {
 @Resource(name="supermarketServiceImpl")
 public SupermarketService supermarketService;
 /**
  * 根据超市id来查询所有的商品
  * @param supermarketId
  * @return
  */
 @ResponseBody
 @RequestMapping(value="findAllCommodity")
 public List<Commodity> findAllCommodity(@RequestParam int supermarketId) {
		List<Commodity> commodities=supermarketService.findAllCommodity(supermarketId);
		return commodities;
	}
 /**
  * 根据supermarketId来查询该超市的相关信息
  * @param supermarketId
  * @return
  */
 @ResponseBody
 @RequestMapping(value="findSingleSuper")
 public SupermarketBean findSingleSuper(@RequestParam int supermarketId) {
	    SupermarketBean supermarketBean=supermarketService.findSingleSuper(supermarketId);
		return supermarketBean;
	}
}
