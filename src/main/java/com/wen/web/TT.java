package com.wen.web;

public class TT {
	private static final String P_A = "111";
	private String name;
	
	public static void main(String[] args) {
		System.out.println(TT.class.getClassLoader());
		System.out.println(TT.class.getClassLoader().getParent());
		System.out.println(TT.class.getClassLoader().getParent().getParent());
	}
	public int test(){
		for(int i=0;i<50;i++){
			System.out.println(i);
		}
		return 50;
	}
}
