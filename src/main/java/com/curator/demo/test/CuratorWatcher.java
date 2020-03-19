/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.curator.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
public class CuratorWatcher {
    private static final Logger         logger     = LoggerFactory.getLogger(CuratorWatcher.class);
    //    private static CacheClientHA redisClient = new CacheClientHA("intlforbidpool", true);

    private static final String         ZK_ADDRESS = CuratorCfg.ZK_ADDRESS;
    private static final String         ZK_PATH    = CuratorCfg.ZK_PATH;

    private static Map<String, Integer> map        = new HashMap<>();

    private static void putMap(String key) {
        Integer val = map.get(key);
        if (val == null) {
            val = 1;
        } else {
            val++;
        }
        map.put(key, val);

    }

    public static void main(String[] args) throws Exception {

        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));
        client.start();
        System.out.println("zk client start successfully!");

        // 2.Register watcher
        PathChildrenCache watcher = new PathChildrenCache(client, ZK_PATH, true // if cache data
        );
        watcher.getListenable().addListener((client1, event) -> {
            try {
                ChildData data = event.getData();
                String s = new String(data.getData());
                JSONObject obj = JSON.parseObject(s);
                long t = obj.getLong("timestamp");
                long used = System.currentTimeMillis() - t;
                String key = getRtScope(used);
                putMap(key);
                logger.info("key=" + key + ",used=" + used);
            } catch (Exception e) {
                logger.error("", e);
            }
        });
//        watcher.start(StartMode.BUILD_INITIAL_CACHE);
        watcher.start();
        System.out.println("Register zk watcher successfully!");

        System.in.read();
        System.out.println("size:" + map.size());
        System.out.println(map);

    }

    private static String getRtScope(long timeConsuming) {
        String s = null;
        if (timeConsuming <= 10) {
            s = "0-10";
        } else if (timeConsuming > 10 && timeConsuming <= 20) {
            s = "10-20";
        } else if (timeConsuming > 20 && timeConsuming <= 30) {
            s = "20-30";
        } else if (timeConsuming > 30 && timeConsuming <= 40) {
            s = "30-40";
        } else if (timeConsuming > 40 && timeConsuming <= 50) {
            s = "40-50";
        } else if (timeConsuming > 50 && timeConsuming <= 60) {
            s = "50-60";
        } else if (timeConsuming > 60 && timeConsuming <= 70) {
            s = "60-70";
        } else if (timeConsuming > 70 && timeConsuming <= 80) {
            s = "70-80";
        } else if (timeConsuming > 80 && timeConsuming <= 90) {
            s = "80-90";
        } else if (timeConsuming > 90 && timeConsuming <= 100) {
            s = "90-100";
        } else if (timeConsuming > 100 && timeConsuming <= 110) {
            s = "100-110";
        } else if (timeConsuming > 110 && timeConsuming <= 120) {
            s = "110-120";
        } else if (timeConsuming > 120 && timeConsuming <= 130) {
            s = "120-130";
        } else if (timeConsuming > 130 && timeConsuming <= 140) {
            s = "130-140";
        } else if (timeConsuming > 140 && timeConsuming <= 150) {
            s = "140-150";
        } else if (timeConsuming > 150 && timeConsuming <= 160) {
            s = "150-160";
        } else if (timeConsuming > 160 && timeConsuming <= 170) {
            s = "160-170";
        } else if (timeConsuming > 170 && timeConsuming <= 180) {
            s = "170-180";
        } else if (timeConsuming > 180 && timeConsuming <= 190) {
            s = "180-190";
        } else if (timeConsuming > 190 && timeConsuming <= 5000) {
            s = "190-5000";
        } else {
            s = "5000+";
        }
        return s + "毫秒";
    }

}
