package com.market.controller;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.entity.Admin;
import com.market.service.AdminService;
import com.market.service.CaptchaService;

/**
 * 登陆验证控制器
 * @author 
 *
 */
@Controller
public class AdminController {

	@Resource(name="adminServiceImpl")
	AdminService adminService;
	@Resource(name="captchaServiceImpl")
	CaptchaService captchaService;
	
	@ResponseBody
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public Map<String,String> login(String adminName ,String password,String validator,@RequestParam String captchaId,HttpSession session) {
		Map<String,String> map=new HashMap<String, String>();
		if(!(captchaService.isValid(captchaId,validator))){
		    map.put("message", "验证码错误");
		    return map;
	    } 
		try{
			Admin admin=adminService.login(adminName, password);
			if(admin==null){
			   map.put("message", "账号不存在");
			   return map;
			}
			if(!admin.getPassword().equals(password)){
		    	map.put("message", "密码错误");
				return map;
		    }
		}catch(Exception e){
			 map.put("message", "登陆失败");
		}
		 map.put("message", "登陆成功");
		 return map;
	}	
}

	    

