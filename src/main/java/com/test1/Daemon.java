package com.test1;

import java.io.IOException;

class Daemon extends Thread  
{  
    private static final int SIZE = 10;  
    private Thread[] t = new Thread[SIZE];  
      
    public Daemon()  
    {  
        setDaemon(true);  
        start();  
    }  
      
    @Override
	public void run()  
    {  
        for(int i = 0; i < SIZE;i++)  
        {  
            t[i] = new DaemonSpawn(i);  
        }  
          
        for(int i = 0; i < SIZE;i++)  
        {  
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());  
        }  
        while(true) yield();  
    }
    
    public static void main(String[] args) throws IOException {
    	 // TODO Auto-generated method stub  
        Thread threadIns = new Daemon();  
        System.out.println("d.isDaemon() = " + threadIns.isDaemon());  
        System.out.println("press any key");  
        System.in.read();
	}
}  
