package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cfg = new ClassPathXmlApplicationContext("spring-config.xml");
		IHelloWorldService h = cfg.getBean(IHelloWorldService.class);
		h.sayHello();
		String[] arr = cfg.getBeanDefinitionNames();
		for (String s : arr) {
			Object o = cfg.getBean(s);

			System.out.println(s + " _ " + o.getClass());

		}
		System.out.println(cfg);
		
	}

}
