package com.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Car1 {
	private Car2 car2;

	public Car2 getCar2() {
		return car2;
	}

	public void setCar2(Car2 car2) {
		this.car2 = car2;
	}

	public Car1() {
		System.out.println("car1 init car2=" + car2);
	}

	public void test1() {
		car2.getClass();
	}

}
