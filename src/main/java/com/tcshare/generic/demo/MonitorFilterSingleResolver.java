package com.tcshare.generic.demo;

/**
 * 
 * @author wsy48420
 * @version $Id: SynMqCounterResolver.java, v 0.1 2018年8月30日 下午8:09:48 wsy48420 Exp $
 */
public class MonitorFilterSingleResolver implements IResolver {

    @Override
    public void resolve(INBKeyValueVO vo) {
        System.out.println("单条过滤调用成功次数+1");
    }

    @Override
    public String getKey() {
        return INBConstants.MONITOR_FILTER_SINGLE;
    }

}
