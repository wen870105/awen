package com.test.migu.singleton.demo;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.test.migu.singleton.SingletonContainer;

/**
 * @author wen
 * @version 1.0
 * @date 2020/3/29 1:16
 */
public class Main {

    public static void main(String[] args) {
        SingletonContainer instance = new SingletonContainer("com.migu.sgw.comm.toolkit.singleton");
        Car car = instance.getBean(Car.class);
        Car1 bean = instance.getBean(Car1.class);
        Car2 bean1 = instance.getBean(Car2.class);
        car.hashCode();

        Map<Class<?>, ISingleton> map = instance.getBeansOfType(ISingleton.class);
        System.out.println(JSON.toJSONString(map));
//		SingletonContainer ctx = SingletonContainer.getInstance();
//		TT t1 = ctx.getBean(TT.class);
//		System.out.println(JSON.toJSONString(t1));
//		Map<Class<?>, ISing> map = ctx.getBeansOfType(ISing.class);
//		System.out.println(JSON.toJSONString(map));

    }
}
