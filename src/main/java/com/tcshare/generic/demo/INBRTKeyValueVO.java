package com.tcshare.generic.demo;

import java.util.concurrent.atomic.AtomicLong;

/**
 *  耗时分布记录
 * @author wsy48420
 * @version $Id: INBKeyValueVO.java, v 0.1 2018年8月30日 下午7:48:32 wsy48420 Exp $
 */
public class INBRTKeyValueVO {

    // v1总耗时,v2存次数
    private AtomicLong val1 = new AtomicLong(0);
    private AtomicLong val2 = new AtomicLong(0);

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

}
