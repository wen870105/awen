package com.test.cglib.filter;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public class ConcreteClassNoInterface {
	public String getConcreteMethodA(String str) {
		System.out.println("ConcreteMethod A ... " + str);
		return str;
	}

	public int getConcreteMethodB(int n) {
		System.out.println("ConcreteMethod B ... " + n);
		return n + 10;
	}

	public int getConcreteMethodFixedValue(int n) {
		System.out.println("getConcreteMethodFixedValue..." + n);
		return n + 10;
	}
	
	
	public static class ConcreteClassCallbackFilter implements CallbackFilter{  
	    public int accept(Method method) {  
	        if("getConcreteMethodB".equals(method.getName())){  
	            return 0;//Callback callbacks[0]  
	        }else if("getConcreteMethodA".equals(method.getName())){  
	            return 1;//Callback callbacks[1]  
	        }else if("getConcreteMethodFixedValue".equals(method.getName())){  
	            return 2;//Callback callbacks[2]  
	        }  
	        return 1;  
	    }  
	}  
	
	public static class ConcreteClassFixedValue implements FixedValue{  
	    public Object loadObject() throws Exception {  
	        System.out.println("ConcreteClassFixedValue loadObject ...");  
	        Object object=999;  
	        return object;  
	    }  
	}  
	
	public static class ConcreteClassInterceptor implements MethodInterceptor{  
	    public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {  
	        System.out.println("Before:"+method);    
	        Object object=proxy.invokeSuper(obj, arg);  
	        System.out.println("After:"+method);   
	        return object;  
	    }  
	}  
	public static void main(String[] args) {
		Enhancer enhancer=new Enhancer();  
		enhancer.setSuperclass(ConcreteClassNoInterface.class);  
		CallbackFilter filter=new ConcreteClassCallbackFilter();  
		enhancer.setCallbackFilter(filter);  
		
		/*
		(1)MethodInterceptor：方法拦截器，上一篇文章中已经详细介绍过，此处不再赘述。
		(2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
		(3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
		*/
		Callback interceptor=new ConcreteClassInterceptor();//(1)  
		Callback noOp=NoOp.INSTANCE;//(2)  
		Callback fixedValue=new ConcreteClassFixedValue();//(3)  
		Callback[] callbacks=new Callback[]{interceptor,noOp,fixedValue};  
		enhancer.setCallbacks(callbacks);  
		ConcreteClassNoInterface proxyObject=(ConcreteClassNoInterface)enhancer.create();  
		
		System.out.println("*** NoOp Callback ***");  
		proxyObject.getConcreteMethodA("abcde");  
		  
		System.out.println("*** MethodInterceptor Callback ***");  
		proxyObject.getConcreteMethodB(1);  
		  
		System.out.println("*** FixedValue Callback ***");  
		int fixed1=proxyObject.getConcreteMethodFixedValue(128);  
		System.out.println("fixedValue1:"+fixed1);  
		int fixed2=proxyObject.getConcreteMethodFixedValue(256);  
		System.out.println("fixedValue2:"+fixed2); 
	}
}
