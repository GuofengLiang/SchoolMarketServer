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
	/**
	 * 修改主分类
	 */
	@ResponseBody
	@RequestMapping(value="alterMainClassify")
	public Map<String, String> alterMainClassify(@RequestParam int mainclassId, String mainclassName) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			mainClassifyService.alterMainClassify(mainclassId, mainclassName);
		}
		 catch (Exception e) {
				map.put("message", "mergeMainClassifyError");
				return map;
			}
			map.put("message", "mergeMainClassifySuccess");
			return map;
	}
	/**
	 * 根据mainclassId来查询该主分类的信息
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleMainClassify")
	public MainClassify findSingleMainClassify(int mainclassId) {
		MainClassify mainClassify = mainClassifyService.findSingleMainClassify(mainclassId);
		return mainClassify;
	}
}
