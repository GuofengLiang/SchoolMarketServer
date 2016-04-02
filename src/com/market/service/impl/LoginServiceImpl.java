package com.market.service.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.market.dao.UserDao;
import com.market.entity.User;
import com.market.service.CaptchaService;
import com.market.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource(name="captchaServiceImpl")
	CaptchaService captchaService;
		
	@Resource(name="userDaoImpl")
	UserDao userDao;
	
	public Map<String,String> login(String txtYhm ,String txtMm,String txtValidator,@RequestParam String captchaId) {
				
		User user=userDao.findSingleUser(txtYhm);
		Map<String,String> map=new HashMap<String,String>();

	    if(!(captchaService.isValid(captchaId,txtValidator))){
		    map.put("loginMessage", "验证码错误");
		    return map;
	    } 
	        
	    if(user==null){
	    	map.put("loginMessage", "输入的教工号不存在");
	 	    return map;	    	
	    }
	    
	    if(!user.getPassword().equals(txtMm)){
	    	map.put("loginMessage", "密码错误");
			return map;
	    }

	    map.put("loginMessage", "ok");
	    return map;

	}
}
