package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//添加主分类
	@ResponseBody
	@RequestMapping(value="addMainClassify")
	public Map<String, String> addMainClassify(String mainclassName) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			mainClassifyService.addMainClassify(mainclassName);
		}
		 catch (Exception e) {
				map.put("message", "addMainClassifyError");
				return map;
			}
			map.put("message", "addMainClassifySuccess");
			return map;
	}
}
