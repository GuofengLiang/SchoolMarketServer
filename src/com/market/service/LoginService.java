package com.market.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

public interface LoginService {
	public Map<String,String> login(String txtYhm ,String txtMm,String txtValidator, String captchaId);
}
