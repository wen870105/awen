package com.test1;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

public class Car2 {

	private Car1 car1;

	private Car2 car2;

	public Car1 getCar1() {
		return car1;
	}

	public void setCar1(Car1 car1) {
		this.car1 = car1;
	}

	public Car2 getCar2() {
		return car2;
	}

	public void setCar2(Car2 car2) {
		this.car2 = car2;
	}

	public Car2() {
		System.out.println("car2 init car1=" + car1);
	}

	public void test() {
		car1.getClass();
	}

	public static void main(String[] args) {

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:beans.xml");
		try {
			System.out.println(res.getURL());
		} catch (IOException e) {
			e.printStackTrace();
		}
		BeanFactory bf = new XmlBeanFactory(res);
		System.out.println("init BeanFactory.");

		Car1 car = bf.getBean(Car1.class);
		bf.getBean(Car.class).getClass();
		System.out.println(JSON.toJSONString(car));
		System.out.println("car bean is ready for use!");
	}
}
