package com.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TTTT {
public static void main(String[] args) {
    File f = new File("D:\\1111\\tfsalecore-11.4\\WEB-INF\\lib");
    f.list();
    
    File f2 = new File("D:\\1111\\tfsalecore\\WEB-INF\\lib");
    Arrays.asList(f2.list());
    List<String> a1 =  new ArrayList<>(Arrays.asList(f.list()));
    List<String> a2 =  new ArrayList<>(Arrays.asList(f2.list()));
    
    
    a2.removeAll(a1);
    System.out.println(a2);
    
}
}
