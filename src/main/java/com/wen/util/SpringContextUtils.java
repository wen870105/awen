package com.wen.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextUtils implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextUtils.context = context;
	}

	public static ApplicationContext getContext() {
		WebUtils bean = context.getBean(WebUtils.class);
		context.getBeansOfType(type)
		return context;
	}
}
