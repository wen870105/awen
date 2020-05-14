/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.test;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author wsy48420
 * @version $Id: C.java, v 0.1 2017年6月28日 下午2:21:56 wsy48420 Exp $
 */
public class Odd extends Thread {

    private BlockingQueue<Integer> bq;

    /**
     * 
     */
    public Odd(BlockingQueue<Integer> bq) {
        this.bq = bq;
    }

    public void run() {
        synchronized (bq) {
            while(!bq.isEmpty()){
            if(bq.peek()%2 != 0){
                try {
                    bq.wait();
                    
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
                continue;
            }
            System.out.println("odd线程=" + bq.poll());
            bq.notify();
            }
        }
        
    }

}
