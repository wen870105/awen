package com.thread.consumer.sortprint;

public class Sort2 extends Thread {
	private Container t1;

	public void setT1(Container t1) {
		this.t1 = t1;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (t1) {
				if (!t1.odd) {
					int s = t1.get();
					t1.odd = true;
					System.out.println("偶数:" + s);
					t1.notify();
				} else {
					try {
						t1.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

}
