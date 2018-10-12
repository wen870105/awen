package com.tcshare.reflect;

public class BeanObj2 {
    private String name;

    public BeanObj2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

}
