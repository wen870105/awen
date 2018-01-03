/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.thread.tezhongbing;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author wsy48420
 * @version $Id: T2.java, v 0.1 2017年6月27日 下午3:43:07 wsy48420 Exp $
 */
public class T2 {
    private final static CyclicBarrier cbOdd   = new CyclicBarrier(2);
    private final static CyclicBarrier cbOrder = new CyclicBarrier(2);
    private static Lock lock = new ReentrantLock();
    private static Condition cdt = lock.newCondition();

    static class T3 implements Runnable {
        private boolean odd = false;

        /**
         * 
         */
        public T3(boolean odd) {
            this.odd = odd;
        }

        public  void run() {
            
            for (int i = 1; i <= 100; i++) {
                try {
                    cbOrder.await();
                    if (!odd && i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() +"__"+ i);
                    }
                    if (odd && i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() +"__"+ i);
//                        cdt.signalAll();
                    }
//                    cdt.await();
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T3 p1 = new T3(false);
        T3 p2 = new T3(true);
        new Thread(p1, "基数").start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(p2, "偶数").start();
      
    }
}
