package com.market.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.javabean.Images;

@Controller
public class ReadJsonController {
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value="/json")
	public List<Images> getUser(){
    	List<Images> list=new ArrayList<Images>();
		Images images1=new Images();
		images1.setDescripe("tupian");
		images1.setFilename("fruits.jpg");
		Images images2=new Images();
		images2.setDescripe("tu");
		images2.setFilename("xigua.jpg");
		list.add(images1);
		list.add(images2);
		return list;
	}
    
}
