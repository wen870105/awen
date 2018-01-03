package com.thread.waitnotify;

public class Service {

	public void testMethod(Object lock) {
		try {
			synchronized (lock) {
				System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
				lock.wait();
				System.out.println("  end wait() ThreadName=" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void synNotifyMethod(Object lock) {
		try {
			synchronized (lock) {
				System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time="
						+ System.currentTimeMillis());
				lock.notify();
				Thread.sleep(5000);
				System.out.println("  end notify() ThreadName=" + Thread.currentThread().getName() + " time="
						+ System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();

		ThreadA a = new ThreadA(lock);
		a.start();

		// NotifyThread notifyThread = new NotifyThread(lock);
		// notifyThread.start();

		SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
		c.start();
	}

}