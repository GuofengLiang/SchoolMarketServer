package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.SubClassify;
import com.market.javabean.SubClassifyBean;
import com.market.service.SubClassifyService;
import com.market.utils.Format;

@Controller
public class SubClassifyController {
	@Resource(name="subClassifyServiceImpl")
	public SubClassifyService subClassifyService;
	/**
	 * 根据mainclassId获取大分类的子类
	 * @param mainclassId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllSubClassify")
	public  List<SubClassifyBean> findAllSubClassify(int mainclassId) {
		List<SubClassifyBean> subClassifies = subClassifyService.findAllSubClassify(mainclassId);
		return subClassifies;
	}

	@ResponseBody
	@RequestMapping(value = "findAllSubClassifies")
	public List<SubClassify> findAllSubClassifies() {
		List<SubClassify> subClass = subClassifyService.findAllSubClassifies();
		return subClass;
	}
	/**
	 * 添加子分类
	 */
	@ResponseBody
	@RequestMapping(value = "addSubClassify")
	public Map<String, String> addSubClassify(String subclassName, int mainclassId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			subClassifyService.addSubClassify(subclassName, mainclassId);
		} catch (Exception e) {
			map.put("message", "addSubClassifyError");
			return map;
		}
		map.put("message", "addSubClassifySuccess");
		return map;
	}
}
