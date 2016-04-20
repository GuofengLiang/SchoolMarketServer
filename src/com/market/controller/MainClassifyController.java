package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.MainClassify;
import com.market.service.MainClassifyService;

@Controller
public class MainClassifyController {
	@Resource(name="mainClassifyServiceImpl")
	public MainClassifyService mainClassifyService;
	
	@ResponseBody
	@RequestMapping(value="findAllMainClassify")
	public List<MainClassify> findAllMainClassify() {
		List<MainClassify> mainClassifies = mainClassifyService.findAllMainClassify();
		return mainClassifies;
	}
	
}
