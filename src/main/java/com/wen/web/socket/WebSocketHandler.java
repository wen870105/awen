package com.wen.web.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 
 * @author Wen
 *
 * @CreateDate 2017年2月13日
 */
@Service
public class WebSocketHandler extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		logger.info("websocket msg=" + message.getPayload());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		TestWebScoketMap.map.put(session.getId(), session);
		logger.info("建立websocket");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		TestWebScoketMap.map.remove(session.getId());
		logger.info("关闭websocket");
	}

	
}