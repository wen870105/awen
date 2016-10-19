package com.test.cglib.methodInterceptor;

import java.io.Serializable;

public class SayHi implements ISayHi ,HH,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String say(String a) {
		System.out.println("hahaha " + a);
		return a;
	}

	@Override
	public String say2(String a, String b) {
		System.out.println("hahaha22222 " + a + "==" +b);
		return a+b;
	}

	@Override
	public void hh(String c) {
		System.out.println("hh====" + c);
		
	}

}
