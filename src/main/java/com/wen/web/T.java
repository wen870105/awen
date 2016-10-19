package com.wen.web;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class T {
	private static final Logger logger = LoggerFactory.getLogger(OrderAction.class);
	@RequestMapping("action/notification/notify")
	public String initCreate(HttpServletRequest request){
		printParams(request);
		String[] ss = new String[]{};
		for(String s : ss){
			
		}
		return "Order1Create";
	}
	private void printParams(HttpServletRequest request) {
		Enumeration enume = request.getParameterNames();
		StringBuilder sb = new StringBuilder();
		while (enume.hasMoreElements()) {
			String key = (String) enume.nextElement();
			String[] val = request.getParameterValues(key);
			sb.append(key).append("=").append(Arrays.toString(val)).append(",");
		}
		logger.info("通知参数:" + sb.toString());
	}
}
