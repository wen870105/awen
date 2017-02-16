package com.wen.web.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 
 * @author Wen
 *
 * @CreateDate 2017年2月13日
 */
@Configuration  
@EnableWebMvc  
@EnableWebSocket 
public class WebSocketConfig implements WebSocketConfigurer {
	@Autowired
	private WebSocketHandler handler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/handler");
	}

}