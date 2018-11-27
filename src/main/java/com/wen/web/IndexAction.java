//package com.wen.web;
//
//import javax.annotation.PostConstruct;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.wen.domain.UserTest;
//import com.wen.domain.base.Page;
//import com.wen.service.UserTestService;
//import com.wen.util.SpringContextUtils;
//
//@Controller
//@RequestMapping("/index")
//public class IndexAction {
//	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
//
////	@Resource(name = "userTestService")
//	@Autowired
//	@Qualifier("userTestService")
//	private UserTestService userTestService;
//
////	@Resource(name = "testRpc")
//	@Autowired
//	@Qualifier("testRpc")
//	private UserTestService rpc;
//
//	@Value("#{configProperties['jdbc.url']}")
//	private String jdbcUrl;
//
//	@PostConstruct
//	private void init() {
//		System.out.println("demo el:" + jdbcUrl);
////		UserTestService uts = SpringContextUtils.getContext().getBean(UserTestService.class);
////		System.out.println("通过静态化的方式获取spring容器里对象:" + uts);
//	}
//
//	@RequestMapping("")
//	public String index(Model model) {
//		rpc.getByName("test");
////		userTestService.getByName("test");
//		logger.info("test");
//		// setList(model);
//		return "index";
//	}
//
//	private void setList(Model model) {
//		Page<UserTest> page = new Page<>(1, 10);
//		UserTest condition = new UserTest();
//		userTestService.selectPage(condition, page);
//		model.addAttribute("page", page);
//	}
//
//	@RequestMapping("save")
//	public String save(UserTest user, Model model) {
//		user.setPwd("123456");
//		userTestService.add(user);
//		return "redirect:../index";
//	}
//
//	@RequestMapping("query")
//	public String query(UserTest condition, Page<UserTest> page, Model model) {
//		page.setPageSize(10);
//		userTestService.selectPage(condition, page);
//		model.addAttribute("page", page);
//		return "index";
//	}
//
//	@RequestMapping("delete")
//	public String delete(long id, Model model) {
//		userTestService.deleteByIds(new long[] { id });
//		return "redirect:../index";
//	}
//
//}
