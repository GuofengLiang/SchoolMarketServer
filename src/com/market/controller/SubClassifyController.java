package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.SubClassify;
import com.market.javabean.SubClassBean;
import com.market.javabean.SubClassifyBean;
import com.market.service.SubClassifyService;

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

	/**
	 * 查找所有的子分类信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllSubClassifies")
	public Map<String,List<SubClassBean>> findAllSubClassifies() {
		Map<String,List<SubClassBean>> map=new HashMap<String,List<SubClassBean>>();
		try{
			List<SubClassBean> subClassBeans = subClassifyService.findAllSubClassifies();
			map.put("data", subClassBeans);
		}catch(Exception e){
			e.printStackTrace();
		}	
		   return  map;
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
	/**
	 * 根据subclassId查找子分类信息
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleSubClassify")
	public SubClassify findSingleSubClassify(int subclassId) {
		SubClassify subClassify = subClassifyService.findSingleSubClassify(subclassId);
		return subClassify;
	}

	/**
	 * 修改分类的信息
	 */
	@ResponseBody
	@RequestMapping(value = "alterClassify")
	public Map<String, String> alterClassify(int subclassId, String subclassName, String mainclassName) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			subClassifyService.alterClassify(subclassId, subclassName, mainclassName);
		} catch (Exception e) {
			map.put("message", "alterClassifyError");
			return map;
		}
		map.put("message", "alterClassifySuccess");
		return map;
	}
	/**
	 * 查找所有主分类下的子分类的信息
	 */
	@ResponseBody
	@RequestMapping(value = "findAllClassify")
	public List<Map<String,Object>> findAllClassify() {
		List<Map<String,Object>> classes = subClassifyService.findAllClassify();
		return classes;
	}
}
