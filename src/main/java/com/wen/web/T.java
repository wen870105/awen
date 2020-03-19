package com.wen.web;

import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class T {
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
	@PostConstruct
	private void init() {
		Thread t= new Thread(()->{
			while(true){
				logger.info("55.3.244.1 GET /index.html 15824 0.043" + System.currentTimeMillis());
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
					logger.error("",e);
				}
			}
		});
		t.start();
	}
}
