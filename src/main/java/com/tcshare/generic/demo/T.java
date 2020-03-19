package com.tcshare.generic.demo;

public class T {
    public static void main(String[] args) {
//        String ctx = INBConstants.SYN_MQ_COUNTER;
        String ctx = INBConstants.MONITOR_FILTER_SINGLE;
        INBResolverRegistry reg = new INBResolverRegistry();
        reg.init();
        IResolver res = reg.get(ctx);
        res.resolve(null);
        //        String ctx = req.
    }

}
