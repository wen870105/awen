package com.test1;

class DaemonSpawn extends Thread  
{  
	int i = 0;
    public DaemonSpawn(int i)  
    {  
    	this.i =i;
        System.out.println("DaemonSpawn " + i + " started");  
        start();  
    }  
      
    @Override
	public void run()  
    {  
        while(true)  
        {  
            yield();  
            System.out.println(i);
        }  
    }  
}  