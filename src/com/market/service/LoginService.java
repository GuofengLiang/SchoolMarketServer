package com.market.service;

import java.util.Map;

public interface LoginService {
	public Map<String,String> login(String txtYhm ,String txtMm,String txtValidator, String captchaId);
}
