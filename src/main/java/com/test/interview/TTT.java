package com.test.interview;

public class TTT {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    //    private String name;

    public static void main(String[] args) {
        String name = "test";
        String name2 = name;

        name2 = "test2";
        System.out.println(name);
//        System.out.println(MAXIMUM_CAPACITY);
//        System.out.println(Integer.MAX_VALUE);
//        for (int i = 2; i < 10; i++) {
//            System.out.println(tableSizeFor(i));
//        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
