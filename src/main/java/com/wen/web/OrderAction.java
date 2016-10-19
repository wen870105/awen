package com.wen.web;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wen.domain.Order;
import com.wen.service.OrderService;
import com.wen.util.ProxyFileUtils;

@Controller
@RequestMapping("/order")
public class OrderAction {
	private static final Logger logger = LoggerFactory.getLogger(OrderAction.class);

	public OrderAction() {
	this.getClass();
	}
	@Value("#{configProperties['jdbc.driverClass']}")
	private String testProperty;

	@Resource
	private OrderService orderService;
	
	@PostConstruct
	private void init() throws Exception{
		System.out.println(testProperty);
		ProxyFileUtils.saveGeneratedCGlibProxyFiles();
		ProxyFileUtils.saveGeneratedJdkProxyFiles();
	}

	@RequestMapping(value = {"initCreate",""})
	public String initCreate(){
		String[] ss = new String[]{};
		for(String s : ss){
			
		}
		return "Order1Create";
	}
//	public String create(){}
	
	@RequestMapping("/test")
	public String test(Order porder, Model model) {
		logger.debug("debug112");
		System.out.println(orderService.getTestJdbc());
		
		porder.getClass();
		if (logger.isDebugEnabled()) {
			logger.debug("is debug ");
		}
		logger.info("info {} number {}" ,"haha" , 111);
		
		Order order = new Order();
		order.setName("haha" + System.currentTimeMillis());
		order.setCreateDate(new Date());
		orderService.add(order);
		model.addAttribute("order", order);
		return "test";
	}

}
