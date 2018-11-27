//package com.tcshare.generic;
//
//public class D3 {
//
//    public static void main(String[] args) {
//
//        Box<String> name = new Box<String>("corn");
//        Box<Integer> age = new Box<Integer>(712);
//
//        System.out.println("name class:" + name.getClass());
//        System.out.println("age class:" + age.getClass());
//        System.out.println(name.getClass() == age.getClass());
//        
//                if (age instanceof Box<Integer>) {
//        
//                }
//
//    }
//
//    public static void getData(Box<Integer> data) {
//        System.out.println("data :" + data.getData());
//    }
//
//    //    private void add(List<String> list) {
//    //
//    //    }
//    //
//    //    private void add(List<Integer> list) {
//    //
//    //    }
//}
//
//class Box<T> {
//
//    private T data;
//
//    public Box() {
//
//    }
//
//    public Box(T data) {
//        this.data = data;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//}
