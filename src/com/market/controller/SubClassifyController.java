package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.SubClassify;
import com.market.service.SubClassifyService;

@Controller
public class SubClassifyController {
	@Resource(name="SubClassifyServiceImpl")
	public SubClassifyService subClassifyService;
	/**
	 * 根据mainclassId获取大分类的子类
	 * @param mainclassId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllSubClassify")
	public  List<SubClassify> findAllSubClassify(@RequestParam int mainclassId) {
		List<SubClassify> subClassifies = subClassifyService.findAllSubClassify(mainclassId);
		return subClassifies;
	}

}
