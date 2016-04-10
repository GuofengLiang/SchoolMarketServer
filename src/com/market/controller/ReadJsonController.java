package com.market.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.javabean.Images;
import com.market.utils.Urlutils;

@Controller
public class ReadJsonController {
 
    @ResponseBody
    @RequestMapping(value="/good/json")
	public List<Images> getUser(HttpServletRequest request){
    	String baseUrl=Urlutils.baseUrl(request);
    	List<Images> list=new ArrayList<Images>();
		Images images1=new Images();
		images1.setDescripe("tupian");
		images1.setFilename(baseUrl+"fruits.jpg");
		Images images2=new Images();
		images2.setDescripe("tu");
		images2.setFilename(baseUrl+"xigua.jpg");
		list.add(images1);
		list.add(images2);
		return list;
	}
    
}
