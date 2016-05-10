package com.market.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.entity.User;
import com.market.javabean.UserBean;
import com.market.service.UserService;
import com.market.utils.FileUtils;

/**
 * 对手机客户端的登陆进行验证
 * 
 * @author guofeng
 * 
 */
@Controller
public class UserController {
	@Resource(name = "userServiceImpl")
	UserService userService;

	/**
	 * 用户根据用户名跟密码登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/userLogin")
	public Map<String, Object> login(String username, String password,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userService.findSingleUser(username);
			if (user == null || user.equals("")) {
				map.put("message", "userError");
				return map;
			}
			if (!user.getPassword().equals(password)) {
				map.put("message", "passwordError");
				return map;
			}
		} catch (Exception e) {
			map.put("message", "userError");
			return map;
		}
		session.setAttribute("username", username);
		UserBean userBean = userService.findUserByName(username);
		map.put("message", userBean);
		//map.put("message", "userloginsuccess");
		return map;
	}

	/**
	 * 根据原来的密码和新的密码来修改密码
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUserPassword")
	public Map<String, String> updatePassword(String oldPassword,
			String newPassword, HttpSession session) {
		String username = (String) session.getAttribute("username");
		Map<String, String> map = new HashMap<String, String>();
		if (username == null) {
			map.put("message", "userError");
			return map;
		}
		try {
			userService.updatePassword(username, oldPassword, newPassword);
		} catch (Exception e) {
			map.put("message", "OldPwdError");
			return map;
		}
		map.put("message", "updatePwdsuccess");
		return map;
	}

	/**
	 * 添加单个用户的基本信息
	 * 
	 * @param userName
	 * @param password
	 * @param userPhone
	 * @param sex
	 * @param portrait
	 */
	@ResponseBody
	@RequestMapping(value = "addSingleUser")
	public Map<String, String> addSingleUser(String userName, String password,
			String userPhone, int sex, String portrait,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		try {
			userService.addSingleUser(userName, password, userPhone, sex,
					portrait, mRequest);
		} catch (Exception e) {
			map.put("message", "addUserError");
			return map;
		}
		map.put("message", "addUserSuccess");
		return map;
	}
	/**
	 * 根据用户用户名查找用户信息
	 */
	@ResponseBody
	@RequestMapping(value = "findSingleUser")
	public UserBean findSingleUser(@RequestParam String username) {
		UserBean userBean = userService.findUserByName(username);
		return userBean;
	}
	/**
	 * 根据用户用户手机号码查找用户信息
	 */
	@ResponseBody
	@RequestMapping(value = "findUserByPhone")
	public UserBean findUserByPhone(@RequestParam String userPhone) {
		UserBean userBean = userService.findUserByPhone(userPhone);
		return userBean;
	}
	/**
	 * 根据用户手机号和密码进行登录
	 */
	@ResponseBody
	@RequestMapping(value = "userLoginByPhone")
	public Map<String, Object> loginByPhone(String userPhone, String password,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user;
		try {
			user = userService.findUserByUPhone(userPhone);
			if (user == null || user.equals("")) {
				map.put("message", "userError");
				return map;
			}
			if (!user.getPassword().equals(password)) {
				map.put("message", "passwordError");
				return map;
			}
		} catch (Exception e) {
			map.put("message", "userError");
			return map;
		}
		session.setAttribute("username",user.getUserName());
		UserBean userBean = userService.findUserByPhone(userPhone);
		map.put("message", userBean);
		return map;
	}
	/**
	 * 根据用户手机号和密码进行注册
	 */
	@ResponseBody
	@RequestMapping(value = "registerNewUser")
	public Map<String, Object> registerNewUser(String userPhone, String password,
			HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userService.findUserByUPhone(userPhone);
			if (user!= null) {
				map.put("message", "userexist");
				return map;
			}
		} catch (Exception e) {
			userService.registerNewUser(userPhone, password);
			@SuppressWarnings("null")
			UserBean userBean =userService.findUserByPhone(userPhone);
			map.put("message", userBean);
			
		}
		return map;
	}
	
	
	
	/**
	 * 修改用户 信息
	 */
	@ResponseBody
	@RequestMapping(value = "alterUser")
	public Map<String, String> alterUser(int userId, String userName, String userPhone,
			int sex, String portrait) {
		Map<String, String> map = new HashMap<String, String>();
		try {
		userService.alterUser(userId, userName, userPhone, sex, portrait);
		} catch (Exception e) {
			map.put("message", "alterUserError");
			return map;
		}
		map.put("message", "alterUserSuccess");
		return map;
	}

	
	
	
	 @RequestMapping(value="/add", method=RequestMethod.POST)
	    public String addUser(int userId, @RequestParam MultipartFile myfiles, HttpServletRequest request) throws IOException{
	        //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
	        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
	        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
	            if(myfiles.isEmpty()){
	                System.out.println("文件未上传");
	            }else{
	                System.out.println("文件长度: " + myfiles.getSize());
	                System.out.println("文件类型: " + myfiles.getContentType());
	                System.out.println("文件名称: " + myfiles.getName());
	                System.out.println("文件原名: " + myfiles.getOriginalFilename());
	                System.out.println("========================================");
	                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
	                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
	                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
	                
	            }
	        return "redirect:/user/list";
	    }
}
