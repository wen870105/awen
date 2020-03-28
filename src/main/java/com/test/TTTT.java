package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import com.alibaba.fastjson.JSON;
import com.test.migu.request.DashboardsRequestDTO;

public class TTTT {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		DashboardsRequestDTO bean = DashboardsRequestDTO.class.newInstance();

		BeanWrapper bw = new BeanWrapperImpl(bean);
		bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//		bw.setPropertyValue("good", "on");
		bw.setPropertyValue("fromDate", "2020-03-19");
		bw.setPropertyValue("toDate", "2020-03-19");
		bw.setPropertyValue("test", "test");

//		BeanMap beanMap = BeanMap.create(bean);
//		beanMap.put("fromDate", "2020-03-19");
//		beanMap.put("toDate", "2020-03-19");
//		beanMap.put("test", "test");

		System.out.println(JSON.toJSONString(bean));

	}
}
