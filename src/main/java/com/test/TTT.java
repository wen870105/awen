package com.test;

public class TTT {
	public Object latch = new Object();
	
	public static int i =0 ;
public static void main(String[] args) throws InterruptedException {
	long start = System.currentTimeMillis();
	
	for(int j=0;j<5;j++){
		
		i++;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				TTT e = new TTT();
				String name = Thread.currentThread().getName();
				synchronized (e.latch) {
					try {
						if(i==4){
						e.latch.wait(5000);
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}	
				}
				long end = System.currentTimeMillis();
				System.out.println(name + " _"+ (end - start));
			}
		},"t"+j);
		t.start();
	}
	
	
	long end = System.currentTimeMillis();
	System.out.println(end - start);
}
}
