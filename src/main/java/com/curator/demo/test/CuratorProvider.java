/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.curator.demo.test;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

//@Service
public class CuratorProvider {
    
    public static void main(String[] args) throws Exception {
        // 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(CuratorCfg.ZK_ADDRESS, new RetryNTimes(3, 5000));
        client.start();
        System.out.println("zk client start successfully!");

        for (int i = 0; i < 1000; i++) {
            String path = CuratorCfg.ZK_PATH + "/cmd-" + i;

            JSONObject obj = new JSONObject();
            obj.put("id", "");
            obj.put("timestamp", System.currentTimeMillis());
            obj.put("cache",
                "'key':'ZH$20181130$9487$Y|ZH$20181130$9093$W^OS','ruleId':165,'tripType':'OW','errorCode':'LY0511004001','ticketCarrier':'ZH','resourceId':'OS','gds':'Amadeus','merchantId':'','account':'','expiredTime':'2018-08-23 17:48:31','traceId':'clmt_13','resource':'1','remainSeatNum':0,'price':0.0,'splitSeg':0,'segments':'1^1^CTU^JJN^false^ZH^9487^Y^null^true^1^JJN^CTU^ZH^9487^Y^320^20181130085000^20181130113500|2^1^JJN^HKG^false^ZH^9093^Y^null^true^1^HKG^JJN^ZH^9093^W^320^20181130180000^20181130193000','depDate':'2018-11-30 08:50:00','returnDate':'1900-01-01 00:00:00'");

            String data1 = obj.toJSONString();
            if (client.checkExists().forPath(path) == null) {
//                print("create", path, data1);
                client.create().forPath(path, data1.getBytes());
            } else {
//                print("setData", path, data1);
                client.setData().forPath(path, data1.getBytes());
            }
            if(i%100==0) {
                System.out.println("每百次打印:" + i);
            }
//            Thread.sleep(5);
        }
//        if (System.currentTimeMillis() % 2 == 0) {
//            System.out.println("delete:" + CuratorCfg.ZK_PATH);
//            List<String> list = client.getChildren().forPath("/");
//            for (String s : list) {
//                client.delete().forPath(s);
//            }
//
//        }

    }

    private static void print(String... cmds) {
        StringBuilder text = new StringBuilder("$ ");
        for (String cmd : cmds) {
            text.append(cmd).append(" ");
        }
        System.out.println(text.toString());
    }

    private static void print(Object result) {
        System.out.println(result instanceof byte[] ? new String((byte[]) result) : result);
    }

}
