package com.test.cglib.methodInterceptor;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class TestProxyMain {
	public static void main(String[] args) {
		SayHi s = new SayHi();
		MyInvocationHandler ih = new MyInvocationHandler(s);
		ISayHi i = (ISayHi)ih.getProxy();
		i.say("llll");
		
		i.say2("bbb", "ccc");
		writeProxyClassToHardDisk("D:/$Proxy22.class");
	}
	
	 /** 
     * 把代理类的字节码写到硬盘上 
     * @param path 保存路径 
     */  
    public static void writeProxyClassToHardDisk(String path) {  
        // 第一种方法，这种方式在刚才分析ProxyGenerator时已经知道了  
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);  
          
        // 第二种方法  
          
        // 获取代理类的字节码  
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy22", SayHi.class.getInterfaces());  
          
        FileOutputStream out = null;  
          
        try {  
            out = new FileOutputStream(path);  
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
