package com.wen.service.listerner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年5月27日
 */
@Component
public class ClassInstanceApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
	private Log logger = LogFactory.getLog(ClassInstanceApplicationListener.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("spring 启动完成,当前所有的实例名称和类型:");
		ApplicationContext fac = event.getApplicationContext();
		String[] arr = fac.getBeanDefinitionNames();
		for (String s : arr) {
			if(fac.isSingleton(s)){
				Object o = fac.getBean(s);
				logger.info("singleton : " + s + " _ " + o.getClass());	
			}else{
				logger.info("property: " + fac.getType(s));				
			}
		}
		logger.info("spring相关数量 " + arr.length);

	}

}
