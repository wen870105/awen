/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.wen.web;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author wsy48420
 * @version $Id: T.java, v 0.1 2017年6月26日 上午11:18:47 wsy48420 Exp $
 */
public class T {
    public final static AtomicInteger TEST_INTEGER = new AtomicInteger(1);
    
    private volatile static int index = 1;
    
    public static void main(String []args) throws InterruptedException {
        System.out.println(Integer.MAX_VALUE);
        final CountDownLatch start_count_down = new CountDownLatch(1);
        final Thread []threads = new Thread[10];
         for(int i = 0 ; i < 10 ; i++) {
             threads[i] = new Thread() {
                 public void run() {
                    try {
                        start_count_down.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    for(int j = 0 ; j < 100 ; j++) {
//                        index++;
//                        TEST_INTEGER.incrementAndGet();
//                    }
                 }
             };
             threads[i].start();
         }
         Thread.sleep(5000);
         start_count_down.countDown();
         for(Thread t : threads) {
             t.join();
         }
         System.out.println("最终运行结果：" + TEST_INTEGER.get());
         System.out.println("最终运行结果：" + index);
    }
}
