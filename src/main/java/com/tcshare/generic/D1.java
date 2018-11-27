package com.tcshare.generic;

import java.util.ArrayList;
import java.util.List;

public class D1 {
        public static void main(String[] args) {
            List<String> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            test(l1);
//            test(l2);
        }
    
        private static void test(List<String> list) {
            System.out.println("string");
        }
    
//        private static void test(List<Integer> list) {
//            System.out.println("Integer");
//        }
}
