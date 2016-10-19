package com.test.cglib.methodInterceptor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.ProxyGenerator;

import com.wen.util.ProxyFileUtils;

public class CglibProxyTTT {
	public static void main(String[] args) throws Exception {
		ProxyFileUtils.saveGeneratedCGlibProxyFiles();
		ProxyFileUtils.saveGeneratedJdkProxyFiles();
		MethodInterceptor mi = new MethodInterceptor() {

			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("hahah");
				proxy.invokeSuper(obj, args);
				return null;
			}
		};
		
		
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(mi);
		enhancer.setSuperclass(SayHi.class);
		SayHi hi = (SayHi) enhancer.create();
		Class<?> clazz = hi.getClass();
		
		for(Class<?> c : clazz.getInterfaces()){
			System.out.println(c);
		}
		
		
		hi.hh("aaaaaaa");
		hi.say("bb");
		
		writeProxyClassToHardDisk("D:/SayHi.class");
		/*
		 * SayHi s = new SayHi(); MyInvocationHandler ih = new
		 * MyInvocationHandler(s); ISayHi i = (ISayHi)ih.getProxy();
		 * i.say("llll");
		 * 
		 * i.say2("bbb", "ccc");
		 */
		
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
		byte[] classFile = ProxyGenerator.generateProxyClass("SayHi$$EnhancerByCGLIB", SayHi.class.getInterfaces());

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
