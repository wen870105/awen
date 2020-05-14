package com.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Car {

	public Car() {
		System.out.println("car==========" + this);
	}

	public void test1() {
		this.getClass();
	}

}
