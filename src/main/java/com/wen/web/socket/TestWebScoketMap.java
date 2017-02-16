package com.wen.web.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 测试用
 * @author Wen
 *
 * @CreateDate 2017年2月13日
 */

public class TestWebScoketMap {
	private static final Logger logger = LoggerFactory.getLogger(TestWebScoketMap.class);
	public static Map<String,WebSocketSession> map = new HashMap<>();
	
	public static void pushMsg(String msg){
		WebSocketSession webSession = TestWebScoketMap.map.entrySet().iterator().next().getValue();
		TextMessage text = new TextMessage("服务器下发数据="+msg);
		try {
			webSession.sendMessage(text);
		} catch (IOException e) {
			logger.error("",e);
		}
	}
}
