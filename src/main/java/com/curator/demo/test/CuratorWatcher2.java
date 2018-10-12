package com.curator.demo.test;
///**
// * LY.com Inc.
// * Copyright (c) 2004-2017 All Rights Reserved.
// */
//package com.ly.flight.intl.forbidpool.client.zk;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.cache.ChildData;
//import org.apache.curator.framework.recipes.cache.PathChildrenCache;
//import org.apache.curator.retry.RetryNTimes;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.ly.tcbase.cacheclient.CacheClientHA;
//
//@Service
//public class CuratorWatcher2 {
//    private static final Logger  logger      = LoggerFactory.getLogger(CuratorWatcher2.class);
//    private static CacheClientHA redisClient = new CacheClientHA("intlforbidpool", true);
//
//    /** Zookeeper info */
//    private static final String  ZK_ADDRESS  = CuratorCfg.ZK_ADDRESS;
//    private static final String  ZK_PATH     = CuratorCfg.ZK_PATH;
//
//    //@PostConstruct
//    private void init() {
//        initListener();
//
//        System.out.println("Register zk watcher successfully!");
//
//    }
//
//    static FileWriter fileWritter = null;
//    static {
//        File f = new File("d:\\javaio-appendfile.txt");
//        fileWritter = new FileWriter(f, true);
//    }
//
//    private static void test() {
//        try {
//
//            //if file doesnt exists, then create it
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            //true = append file
//
//            fileWritter.write(data);
//            fileWritter.close();
//
//            System.out.println("Done");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//
//        initListener();
//
//        System.out.println("Register zk watcher successfully!");
//
//    }
//
//    private static void initListener() {
//        // 1.Connect to zk
//        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(3, 5000));
//        client.start();
//        System.out.println("zk client start successfully!");
//
//        // 2.Register watcher
//        PathChildrenCache watcher = new PathChildrenCache(client, ZK_PATH, true // if cache data
//        );
//        watcher.getListenable().addListener((client1, event) -> {
//            try {
//                ChildData data = event.getData();
//                JSONObject obj = JSON.parseObject(new String(data.getData()));
//                long t = obj.getLong("timestamp");
//                long used = System.currentTimeMillis() - t;
//                String key = getRtScope(used);
//                logger.info("key=" + key + ",used=" + used);
//            } catch (Exception e) {
//                logger.error("", e);
//            }
//
//        });
//        try {
//            watcher.start();
//        } catch (Exception e) {
//            logger.error("", e);
//        }
//    }
//
//    private static String getRtScope(long timeConsuming) {
//        String s = null;
//        if (timeConsuming <= 10) {
//            s = "0-10";
//        } else if (timeConsuming > 10 && timeConsuming <= 20) {
//            s = "10-20";
//        } else if (timeConsuming > 20 && timeConsuming <= 30) {
//            s = "20-30";
//        } else if (timeConsuming > 30 && timeConsuming <= 40) {
//            s = "30-40";
//        } else if (timeConsuming > 40 && timeConsuming <= 200) {
//            s = "40-200";
//        } else if (timeConsuming > 200 && timeConsuming <= 500) {
//            s = "200-500";
//        } else if (timeConsuming > 500 && timeConsuming <= 1000) {
//            s = "500-1000";
//        } else if (timeConsuming > 1000 && timeConsuming <= 2000) {
//            s = "1000-2000";
//        } else if (timeConsuming > 2000 && timeConsuming <= 5000) {
//            s = "2000-5000";
//        } else {
//            s = "5000+";
//        }
//        return s + "毫秒";
//    }
//
//}
