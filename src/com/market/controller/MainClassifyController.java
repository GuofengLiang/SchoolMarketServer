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
	/**
	 * 这个接口暂时没用到
	 * @param mainclassId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delectClassify")
	public Map<String,String> delectClassify(int mainclassId) {
		Map<String,String> map=new HashMap<String,String>();
		try{
			mainClassifyService.delectClassify(mainclassId);
		}catch(Exception e){
			e.printStackTrace();
			map.put("message", "delectError");
			return map;
		}
		  map.put("message", "delectSuccess");
		return map;
	}
}
