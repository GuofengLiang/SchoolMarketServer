package com.market.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.market.entity.User;
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

	@ResponseBody
	@RequestMapping(value = "/userLogin")
	public Map<String, String> login(String username, String password,
			HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
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
		map.put("message", "success");
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
	 * 添加单个用户
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
}
