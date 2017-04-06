package com.wen.web;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.domain.ExportWen;
import com.wen.domain.MerchantCallOut;
import com.wen.domain.base.Page;
import com.wen.export.User;
import com.wen.service.ExportWenService;
import com.wen.service.MerchantCallOutService;
import com.wen.service.UserServiceImpl;
import com.wen.web.socket.TestWebScoketMap;

@Controller
@RequestMapping("/index")
public class IndexAction {
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
	@Autowired
	private ExportWenService exportWenService;
	@Autowired
	private UserServiceImpl UserService;
	@Autowired
	private MerchantCallOutService merchantCallOutService;
	
	private static int counter = 1;
	@RequestMapping("")
	public String index() {
		logger.info("test");
		User u = new User();
		u.setName("query");
		UserService.test(u);
		return "index";
	}
	
	int i = 0;
	@ResponseBody
	@RequestMapping("test222")
	public Object test222() {
		long start = System.currentTimeMillis();
		int threadCounter =10;
		final CountDownLatch latch=new CountDownLatch(threadCounter*2);//两个工人的协作  
		ExecutorService exec = Executors.newFixedThreadPool(threadCounter*2);

		//修改总页数
		for(int i=0;i<threadCounter;i++){
			final int temp = i;
			exec.execute(new Runnable() {

				@Override
				public void run() {
					List<MerchantCallOut> list = merchantCallOutService. queryUpdate(387L, 1591, 1);
					latch.countDown();
					System.out.println("update : " + list.size() + "__" + latch.getCount());
				}
				
			});	
			
			exec.execute(new Runnable() {

				@Override
				public void run() {
					MerchantCallOut query = new MerchantCallOut();
					if(temp%2==0){
						query.setPhone("18113025608");	
					}else{
						query.setPhone("18382479394");	
					}
					
					List<MerchantCallOut> list = merchantCallOutService.findList_(query);
					latch.countDown();
					System.out.println("find : " + list.size() + "__" + latch.getCount());
					
				}
			});	
		}


		exec.shutdown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("结束当前任务用时:{}ms {}", (System.currentTimeMillis()-start),counter);
		return "ok";
	}
	
	@RequestMapping("websocket")
	public String websocket() {
		logger.info("test");
		return "websocket";
	}
	
	@ResponseBody
	@RequestMapping("msg")
	public String index(String msg) {
		TestWebScoketMap.pushMsg(msg);
		return "{status:success}";
	}
	
	@RequestMapping("wen")
	public String wen() {
		long start = System.currentTimeMillis();
		 CountDownLatch latch=new CountDownLatch(14);//两个工人的协作  
		ExecutorService exec = Executors.newFixedThreadPool(6);
		
		//修改总页数
		for(int i=0;i<15;i++){
			ExportWen query = new  ExportWen();
			query.setCurrPage(i+1);
			query.setPerItems(500);
			Page<ExportWen> page = exportWenService.queryPage(query);	
			exec.execute(new DownloadRecord(page,latch));		
		}
		
//		ExportWen query = new  ExportWen();
//		query.setCurrPage(1);
//		query.setPerItems(10);
//		Page<ExportWen> page = exportWenService.queryPage(query);	
		
		exec.shutdown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("结束当前任务用时:{}ms {}", (System.currentTimeMillis()-start),counter);
		return "index";
	}
	
	static class DownloadRecord implements Runnable{
		private Page<ExportWen> page;
		private CountDownLatch latch;
		public DownloadRecord(Page<ExportWen> page,CountDownLatch latch) {
			this.page = page;
			this.latch = latch;
		}
		@Override
		public void run() {
			long start = System.currentTimeMillis();
			String name = Thread.currentThread().getName();
			logger.info("{}-开始当前任务.",name);
			if(page!=null && page.getTotalCount()>0){
				File dir = new File("F:\\18301593586\\");
				URL url;
				File f = null;
				
				for(ExportWen ew : page.getResult()){
					if(StringUtils.isBlank(ew.getRecordUrl())){
						continue;
					}
					String ext = ew.getRecordUrl().substring(ew.getRecordUrl().lastIndexOf("/")+1) ;
					String fName = ew.getCreateTime() != null ? new DateTime(ew.getCreateTime()).toString("yyyy_MM_dd_HH_mm_ss")
							: "";
					fName+=("_"+ext);
					fName = counter + "-" +fName;
					counter++;
					if(counter%100==0){
						logger.info("downloading idx = " + counter );
					}
					try {
						url = new URL(ew.getRecordUrl());
						f = new File(dir, fName);
						FileUtils.copyURLToFile(url, f);
					} catch (Exception e) {
						logger.error("",e);
					}
				}			
			}
			logger.info("结束当前任务用时:{}ms", (System.currentTimeMillis()-start));
			latch.countDown();
		}
	}
	public static void main(String[] args) {
		String s = "http://o8du2f4ii.bkt.clouddn.com/2017-01/1612261429080049000102270000bee6.wav";
		String s1 = s.substring(s.lastIndexOf("/")+1) ;
		System.out.println(s1);
	}
}
