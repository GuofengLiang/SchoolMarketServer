package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.entity.User;
import com.market.javabean.UserBean;
import com.market.service.UserService;

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
		User user = userService.findUserByUPhone(userPhone);
		try {
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
	
}
