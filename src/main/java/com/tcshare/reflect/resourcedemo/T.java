package com.tcshare.reflect.resourcedemo;

public class T {
    public static void main(String[] args) {
        ResourceData data = ResourceHolder.getData();
        String url = data.getInternationalUrl();
        String internalUrl = data.getInternalUrl();
        String securityCode = data.getSecurityCode();
        String pid = data.getPid();

        System.out.println("url=" + url);
        System.out.println("internalUrl=" + internalUrl);
        System.out.println("pid=" + pid);
        System.out.println("securityCode=" + securityCode);

        System.out.println("ext=" + data.getExt());
    }
}
