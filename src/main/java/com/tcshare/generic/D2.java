//package com.tcshare.generic;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class D2 {
//    public static void main(String[] args) {
//        // integer 是 number子类
//        List<Number> l1 = new ArrayList<>();
//        List<Integer> l2 = new ArrayList<>();
//        test(l1);
//        test(l2);
//    }
//
//    private static void test(List<? extends Number> list) {
//        Number n =null;
//        list.add(n);
//        System.out.println("string");
//    }
//
//}
