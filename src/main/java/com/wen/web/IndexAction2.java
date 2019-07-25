package com.wen.web;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wen.domain.UserTest;
import com.wen.domain.base.Page;
import com.wen.service.UserTestService;
import com.wen.util.SpringContextUtils;

@Controller
@RequestMapping("/index2")
public class IndexAction2 {
	private static final Logger logger = LoggerFactory.getLogger(IndexAction2.class);

	@RequestMapping("")
	public String index(Model model) {
		return "websocket";
	}

	
}
