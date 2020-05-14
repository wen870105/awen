package com.test.interview;

import java.util.concurrent.ArrayBlockingQueue;

public class TwoThreadPrint {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> oddQueue = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Integer> evenQueue = new ArrayBlockingQueue<>(1);
        Thread oddThd = new Thread("oddThd") {
            @Override
            public void run() {
                Integer poll = 0;
                for (;;) {
                    try {
                        poll = oddQueue.take();
//                        if(poll==99) {
//                            evenQueue.put(poll);
//                            break;
//                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    poll++;
                    System.out.println(getName() + ":" + poll);
                    
                    try {
                        evenQueue.put(poll);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                  
                }
            }

        };

        Thread evenThd = new Thread("evenThd") {
            @Override
            public void run() {
                Integer poll = 0;
                for (;;) {
                    try {
                        poll = evenQueue.take();
//                        if(poll==99) {
//                            oddQueue.put(poll);
//                            break;
//                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    poll++;
                    System.out.println(getName() + ":" + poll);                  
                    try {
                        oddQueue.put(poll);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        oddThd.start();
        evenThd.start();
        System.out.println("1111");
       
        try {
            Thread.sleep(1000);
            oddQueue.add(0);
            oddThd.join();
            evenThd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
