package com.test;

public class HelloWorldServiceImpl implements IHelloWorldService {
	public HelloWorldServiceImpl() {
	System.out.println("HelloWorldServiceImpl");
	}
	@Override
	public void sayHello() {
		System.out.println("============Hello World!");
	}
}
