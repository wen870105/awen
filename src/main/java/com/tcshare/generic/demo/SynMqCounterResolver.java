package com.tcshare.generic.demo;

/**
 * 客户端数据同步消费次数统计,调用加1次
 * 
 * @author wsy48420
 * @version $Id: SynMqCounterResolver.java, v 0.1 2018年8月30日 下午8:09:48 wsy48420 Exp $
 */
public class SynMqCounterResolver implements IResolver {

    @Override
    public void resolve(INBKeyValueVO vo) {
        System.out.println("同步消费次数+1");
        //        ForbidpoolINB.monitor(ClientINBUtils.CLIENT, "同步消费次数", vo.getVal1().get());
    }

    @Override
    public String getKey() {
        return INBConstants.SYN_MQ_COUNTER;
    }

}
