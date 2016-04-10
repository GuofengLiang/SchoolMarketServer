package com.market.utils;

import javax.servlet.http.HttpServletRequest;

public class Urlutils {
   public static final String UPLOADDIR="uploadDir/";
   public static String baseUrl(HttpServletRequest request){
	   StringBuffer url = request.getRequestURL();  
	   String baseUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString()+UPLOADDIR;  
       return baseUrl;
   };
}
