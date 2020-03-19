package com.tcshare.generic.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author wsy48420
 * @version $Id: INBKeyValueVO.java, v 0.1 2018年8月30日 下午7:48:32 wsy48420 Exp $
 */
public class INBKeyValueVO {
    // 耗时分布记录key
    private Map<String, INBRTKeyValueVO> consumeTimeMap = new ConcurrentHashMap<>();

    private String                       key2;
    private String                       key3;
    private AtomicLong                   val1           = new AtomicLong(0);
    private AtomicLong                   val2           = new AtomicLong(0);
    

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public AtomicLong getVal1() {
        return val1;
    }

    public void setVal1(AtomicLong val1) {
        this.val1 = val1;
    }

    public AtomicLong getVal2() {
        return val2;
    }

    public void setVal2(AtomicLong val2) {
        this.val2 = val2;
    }

    public Map<String, INBRTKeyValueVO> getConsumeTimeMap() {
        return consumeTimeMap;
    }

    public void setConsumeTimeMap(Map<String, INBRTKeyValueVO> consumeTimeMap) {
        this.consumeTimeMap = consumeTimeMap;
    }

}
