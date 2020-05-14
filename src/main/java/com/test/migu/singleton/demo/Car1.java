package com.test.migu.singleton.demo;

import com.test.migu.singleton.Inject;
import com.test.migu.singleton.Singleton;

@Singleton
public class Car1 implements ISingleton {
    @Inject
    private Car2 car2;


    public Car1() {
        System.out.println("car1 init car2=" + car2);
    }

    public void test1() {
        car2.getClass();
    }

}
