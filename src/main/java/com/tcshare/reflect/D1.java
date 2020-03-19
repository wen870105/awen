package com.tcshare.reflect;

import java.lang.reflect.Constructor;

public class D1 {
    public static void main(String[] args) throws Exception {        
        Constructor<?> constructor = BeanObj2.class.getConstructors()[0];
    }
    
    private void test1() throws Exception{
//        Class<?> clazz = Class.forName("com.ly.com.xxx");
        BeanObj obj = BeanObj.class.newInstance();
        obj.setName("tc");
        System.out.println(obj.toString());
    }
}
