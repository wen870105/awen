package com.wen.web;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.service.cache.JedisCacheService;
import com.wen.web.socket.TestWebScoketMap;

@Controller
@RequestMapping("/index")
public class IndexAction {
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
	@Autowired
	private JedisCacheService cacheService;

	@Value("#{configProperties['jdbc.url']}")
	private String jdbcUrl;
	
	@PostConstruct
	private void init(){
	    System.out.println(jdbcUrl);
	}
	
	private static int counter = 1;
	@RequestMapping("")
	public String index() {
	    cacheService.set("test12356", 123);
		logger.info("test");
		return "index";
	}
	
	@RequestMapping("websocket")
	public String websocket() {
		logger.info("test");
		return "websocket";
	}
	
	@ResponseBody
	@RequestMapping("msg")
	public String index(String msg) {
		TestWebScoketMap.pushMsg(msg);
		return "{status:success}";
	}
	
}
