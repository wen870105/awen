package com.thread.waitnotify;

public class SynNotifyMethodThread extends Thread {
	private Object lock;

	public SynNotifyMethodThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		Service service = new Service();
		service.synNotifyMethod(lock);
	}
}