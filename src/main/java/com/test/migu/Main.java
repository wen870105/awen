package com.test.migu;

import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.test.migu.request.BizAnalysisDetailRequestDTO;
import com.test.migu.request.BizAnalysisGroupRequestDTO;
import com.test.migu.request.BizAnalysisRequestDTO;
import com.test.migu.request.DashboardsRequestDTO;
import com.test.migu.request.FlowAnalysisDateRequestDTO;
import com.test.migu.request.FlowAnalysisHoursRequestDTO;
import com.test.migu.request.FlowAnalysisMinutesDetailRequestDTO;
import com.test.migu.request.FlowAnalysisMinutesRequestDTO;
import com.test.migu.response.BaseResponseDTO;
import com.test.migu.response.BizAnalysisDetailResponseDTO;
import com.test.migu.response.BizAnalysisGroupResponseDTO;
import com.test.migu.response.BizAnalysisResponseDTO;
import com.test.migu.response.DashboardsResponseDTO;
import com.test.migu.response.EntryDTO;
import com.test.migu.response.FlowAnalysisDateResponseDTO;
import com.test.migu.response.FlowAnalysisHoursResponseDTO;
import com.test.migu.response.FlowAnalysisMinutesDetailResponseDTO;
import com.test.migu.response.FlowAnalysisMinutesResponseDTO;
import com.test.migu.response.SerieDTO;

public class Main {
	public static void main(String[] args) {
		dashboards();
		bizAnalysis();
		bizAnalysisDetail();
		bizAnalysisGroup();
		flowAnalysisDate();
		flowAnalysisHours();
		flowAnalysisMinute();
		flowAnalysisMinuteDetail();
	}
	
	private static void flowAnalysisMinuteDetail() {
		FlowAnalysisMinutesDetailRequestDTO req = new FlowAnalysisMinutesDetailRequestDTO();

		req.setDomain("www.xxx.com");
		req.setEntry("/entry");
		req.setQueryDate("2020-03-15");
		req.setFromTime("6:00");
		req.setToTime("12:00");
		req.setReqIp("127.0.0.1");

		
		FlowAnalysisMinutesDetailResponseDTO d1 = new FlowAnalysisMinutesDetailResponseDTO();
		d1.setAccessDate("2020-03-19 14:00:00");
		d1.setCanvasId("testCanvasid");
		d1.setPath("/login");
		d1.setRegion("成都");
		d1.setReqIp("127.0.0.1");
		d1.setUserAgent("chrome");
		
		FlowAnalysisMinutesDetailResponseDTO d2 = new FlowAnalysisMinutesDetailResponseDTO();
		d2.setAccessDate("2020-03-19 14:01:00");
		d2.setCanvasId("testCanvasid2");
		d2.setPath("/login2");
		d2.setRegion("大连");
		d2.setReqIp("127.0.0.1");
		d2.setUserAgent("firefox");
		

		System.out.println("flowAnalysisMinuteDetail request:" + JSON.toJSONString(req));
		System.out.println("flowAnalysisMinuteDetail request:" + JSON.toJSONString(build(Arrays.asList(d1,d2))));
	}
	private static void flowAnalysisMinute() {
		FlowAnalysisMinutesRequestDTO req = new FlowAnalysisMinutesRequestDTO();
		FlowAnalysisMinutesResponseDTO resp = new FlowAnalysisMinutesResponseDTO();

		req.setDomain("www.xxx.com");
		req.setEntry("/entry");
		req.setQueryDate("2020-03-15");
		req.setFromTime("6:00");
		req.setToTime("12:00");

		List<String> header = Arrays.asList("1:00", "3:00", "5:00","7:00","9:00");

		SerieDTO s1 =new SerieDTO();		
		s1.setData(Arrays.asList("1", "3", "9", "27", "81"));
		s1.setName("当日数据");
		
		SerieDTO s2 =new SerieDTO();	
		s2.setData(Arrays.asList("3", "2", "7", "10", "50"));
		s2.setName("五日平均");
		
		FlowAnalysisMinutesResponseDTO d1 = new FlowAnalysisMinutesResponseDTO();
		d1.setHitRules("90");
		d1.setReqIp("127.0.0.1");
		d1.setReqTotal("100");
		d1.setSection("6:00-12:00");
		
		FlowAnalysisMinutesResponseDTO d2 = new FlowAnalysisMinutesResponseDTO();
		d2.setHitRules("80");
		d2.setReqIp("127.0.0.2");
		d2.setReqTotal("90");
		d2.setSection("6:00-12:00");

		System.out.println("flowAnalysisMinute request:" + JSON.toJSONString(req));
		System.out.println("flowAnalysisMinute request:" + JSON.toJSONString(build(Arrays.asList(d1,d2))));
	}

	private static void flowAnalysisHours() {
		FlowAnalysisHoursRequestDTO req = new FlowAnalysisHoursRequestDTO();
		FlowAnalysisHoursResponseDTO resp = new FlowAnalysisHoursResponseDTO();

		req.setType("hour");
		req.setDomain("www.xxx.com");
		req.setEntry("/entry");
		req.setQueryDate("2020-03-15");

		List<String> header = Arrays.asList("1:00", "3:00", "5:00", "7:00", "9:00");

		SerieDTO s1 = new SerieDTO();
		s1.setData(Arrays.asList("1", "3", "9", "27", "81"));
		s1.setName("当日数据");

		SerieDTO s2 = new SerieDTO();
		s2.setData(Arrays.asList("3", "2", "7", "10", "50"));
		s2.setName("五日平均");
		resp.setColumns(header);
		resp.setSeries(Arrays.asList(s1, s2));

		System.out.println("flowAnalysisHours request:" + JSON.toJSONString(req));
		System.out.println("flowAnalysisHours request:" + JSON.toJSONString(build(resp)));
	}
	private static void flowAnalysisDate() {
		FlowAnalysisDateRequestDTO req = new FlowAnalysisDateRequestDTO();
		FlowAnalysisDateResponseDTO resp = new FlowAnalysisDateResponseDTO();

		req.setFromDate("2020-03-15");
		req.setToDate("2020-03-19");

		List<String> header = Arrays.asList("2020-03-15", "2020-03-16", "2020-03-17","2020-03-18","2020-03-19");

		List<String> l1 = Arrays.asList("10", "20", "30","40", "50", "60");
		resp.setColumns(header);
		resp.setValList(l1);

		System.out.println("flowAnalysisDate request:" + JSON.toJSONString(req));
		System.out.println("flowAnalysisDate request:" + JSON.toJSONString(build(resp)));
	}
	

	private static void bizAnalysisGroup() {
		BizAnalysisGroupRequestDTO req = new BizAnalysisGroupRequestDTO();
		BizAnalysisGroupResponseDTO resp = new BizAnalysisGroupResponseDTO();

		req.setQuery("action=post and attack_type=\"auto_scan\"");
		req.setQueryColumn("path");

		List<String> header = Arrays.asList("字段值", "数量", "百分比");

		List<String> l1 = Arrays.asList("/login", "10", "10%");
		List<String> l2 = Arrays.asList("/test1", "5", "5%");
		List<String> l3 = Arrays.asList("/test2", "1", "1%");
		resp.setColumns(header);
		resp.setValList(Arrays.asList(l1, l2, l3));

		System.out.println("bizAnalysisGroup request:" + JSON.toJSONString(req));
		System.out.println("bizAnalysisGroup request:" + JSON.toJSONString(build(resp)));
	}

	private static void bizAnalysisDetail() {
		BizAnalysisDetailRequestDTO req = new BizAnalysisDetailRequestDTO();
		BizAnalysisDetailResponseDTO resp = new BizAnalysisDetailResponseDTO();

		List<String> header = Arrays.asList("time", "path", "host", "action", "attack_type");
		req.setQuery("action=post and attack_type=\"auto_scan\"");
		req.setColumns(header);
		req.setQueryColumn("time");

		List<String> l1 = Arrays.asList("2020-03-19 12:00:00", "/login", "game.migu.cn", "post", "autoscan");
		List<String> l2 = Arrays.asList("2020-03-18 12:00:00", "/test1", "game1.migu.cn", "post", "autoscan");
		List<String> l3 = Arrays.asList("2020-03-17 12:00:00", "/test2", "game2.migu.cn", "post", "autoscan");
		resp.setColumns(header);
		resp.setValList(Arrays.asList(l1, l2, l3));

		System.out.println("bizAnalysisDetail request:" + JSON.toJSONString(req));
		System.out.println("bizAnalysisDetail request:" + JSON.toJSONString(build(resp)));
	}

	private static void bizAnalysis() {
		BizAnalysisRequestDTO req = new BizAnalysisRequestDTO();
		req.setQuery("action=post and attack_type=\"auto_scan\"");
		req.setType("detail");

		BizAnalysisResponseDTO resp = new BizAnalysisResponseDTO();
		EntryDTO e1 = new EntryDTO();
		e1.setName("time");
		e1.setVal("100");

		EntryDTO e2 = new EntryDTO();
		e2.setName("path");
		e2.setVal("70");

		EntryDTO e3 = new EntryDTO();
		e3.setName("host");
		e3.setVal("20");

		EntryDTO e4 = new EntryDTO();
		e4.setName("action");
		e4.setVal("5");

		
		resp.setColumns(Arrays.asList(e1, e2, e3, e4));
		System.out.println("bizAnalysis request:" + JSON.toJSONString(req));
		System.out.println("bizAnalysis request:" + JSON.toJSONString(build(resp)));
	}

	private static void dashboards() {
		DashboardsRequestDTO req = new DashboardsRequestDTO();
		req.setFromDate("2020-03-19");
		req.setToDate("2020-03-25");

		DashboardsResponseDTO resp = new DashboardsResponseDTO();
		resp.setTotalReq(100);
		resp.setNormalReq(90);
		resp.setExceptionReq(10);
		resp.setWhiteListReq(5);

		EntryDTO r1 = new EntryDTO();
		resp.setRegionReqList(Arrays.asList(r1));

		EntryDTO e1 = new EntryDTO();
		e1.setName("动态扫描");
		e1.setVal("5");
		EntryDTO e2 = new EntryDTO();
		e2.setName("高频");
		e2.setVal("10");
		EntryDTO e3 = new EntryDTO();
		e3.setName("机器人");
		e3.setVal("20");
		resp.setExceptionPercent(Arrays.asList(e1, e2, e3));

		EntryDTO e4 = new EntryDTO();
		e4.setName("curl");
		e4.setVal("200");

		EntryDTO e5 = new EntryDTO();
		e5.setName("java");
		e5.setVal("150");

		EntryDTO e6 = new EntryDTO();
		e6.setName("headless");
		e6.setVal("75");
		resp.setToolsPercent(Arrays.asList(e4, e5, e6));

		
		System.out.println("dashboards request:" + JSON.toJSONString(req));
		System.out.println("dashboards request:" + JSON.toJSONString(build(resp)));
	}
	
	private static BaseResponseDTO build(Object obj) {
		BaseResponseDTO  resp =new BaseResponseDTO();
		resp.setCode("200");
		resp.setMsg("success");
		resp.setData(obj);
		return resp;
	}
}
