package com.test.migu.singleton.demo;

import com.test.migu.singleton.Init;
import com.test.migu.singleton.Singleton;

@Singleton
public class Car {

	public Car() {
		System.out.println("car==========" + this);
	}

	@Init
	public void test1() {
		System.out.println("托尔==========" + this);
		this.getClass();
	}

}
