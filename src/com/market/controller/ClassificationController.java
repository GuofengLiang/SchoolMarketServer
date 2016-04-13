package com.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Classification;
import com.market.entity.Commodity;
import com.market.service.ClassificationService;

@Controller
public class ClassificationController {
	@Resource(name="ClassificationServiceImpl")
	public ClassificationService classificationService;
	/**
	 * 根据分类id来查找该分类的所有商品
	 * @param classiId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findAllCommodity")
	public List<Commodity> findAllCommodity(@RequestParam int classId){
		
		List<Commodity> commodities = classificationService.findAllCommodity(classId);
		return commodities;
	}
	/**
	 * 根据分类id来查找该分类的相关信息
	 * @param classiId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findSingleClass")
	public Classification findSingleClass(@RequestParam int classId){
		
		Classification classification = classificationService.findSingleClass(classId);
		return classification;
	}

}
