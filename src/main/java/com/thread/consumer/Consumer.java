package com.thread.consumer;

public class Consumer extends Thread {
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		while (true) {
			String s = Container.get(obj);
			System.out.println("consumer:" + s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
