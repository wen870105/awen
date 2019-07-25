package com.baobaotao.aspectj.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.NaiveWaiter;

public class T {
    public static void main(String[] args) {
        ApplicationContext cfg = new ClassPathXmlApplicationContext("com/baobaotao/aspectj/advanced/beans.xml");
        NaiveWaiter bean = cfg.getBean("naiveWaiter", NaiveWaiter.class);
        bean.serveTo("111");
    }
}
