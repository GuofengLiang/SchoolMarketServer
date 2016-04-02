package com.market.controller;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.market.service.LoginService;

/**
 * 登陆验证控制器
 * @author 
 *
 */
@Controller
public class LoginController {

	@Resource(name="loginServiceImpl")
	LoginService loginService;
	
	
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public Map<String,String> login(String txtYhm ,String txtMm,String txtValidator,@RequestParam String captchaId,HttpSession session) {
		Map<String,String> map=new HashMap<String, String>();
			map=loginService.login(txtYhm, txtMm, txtValidator, captchaId);
			if(map.get("loginMessage").equals("ok")){
				session.setAttribute("managerId", txtYhm);
				map.put("message", "登陆成功");//xiao代表跳转到校级管理员页面
			}else{
			map.put("message", "登陆失败");//xiao代表跳转到校级管理员页面
			}
			return map;
	}	
}

	    

