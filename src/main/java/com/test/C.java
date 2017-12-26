/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author wsy48420
 * @version $Id: C.java, v 0.1 2017年6月28日 下午2:21:56 wsy48420 Exp $
 */
public class C extends Thread {

    private BlockingQueue<Integer> bq;

    /**
     * 
     */
    public C(BlockingQueue<Integer> bq) {
        this.bq = bq;
    }

    public void run() {
        synchronized (bq) {
            while (!bq.isEmpty()) {
                if (bq.peek() % 2 == 0) {
                    try {
                        bq.wait();
                      
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }  
                    continue;
                }
                System.out.println("奇数线程=" + bq.poll());
                bq.notify();
            }
        }

    }

    public static void main11(String[] args) {
        ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(100);
//        bq.add(1);
//        bq.poll();
        for (int i = 1; i <= 100; i++) {
            bq.add(i);
        }
        new C(bq).start();
        new Odd(bq).start();
//        System.out.println(bq.peek() %2 ==0);
        
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<30;i++){
            l.add(i);
        }
        ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(20,false,l);
        System.out.println(bq.peek());
    }
}
