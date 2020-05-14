package com.thread.consumer.sortprint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import com.test.C;

public class Container {
	public List<Integer> list = new ArrayList<>();
	public boolean odd = true;

	public void init() {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list);
	}

	public Integer get() {

		if (list.size() == 0) {
			synchronized (Container.class) {
				try {
					Container.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		int s = list.get(0);
		list.remove(0);

		return s;
	}

	public static void main(String[] args) throws IOException {
		Container c1 = new Container();
		c1.init();
		Sort1 s1 = new Sort1();
		Sort2 s2 = new Sort2();
		s1.setT1(c1);
		s2.setT1(c1);

		s2.start();
		s1.start();

		// try {
		// c.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
