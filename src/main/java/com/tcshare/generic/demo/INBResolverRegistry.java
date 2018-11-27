/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.tcshare.generic.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author wsy48420
 * @version $Id: RequestResolverRegistry.java, v 0.1 2018年5月2日 下午2:04:55 wsy48420 Exp $
 */
public class INBResolverRegistry {
    private Map<String, IResolver> requestResolverMap = new HashMap<>();

    public void init() {
        SynMqCounterResolver r1 = new SynMqCounterResolver();
        MonitorFilterSingleResolver r6 = new MonitorFilterSingleResolver();

        requestResolverMap.put(r1.getKey(), r1);
        requestResolverMap.put(r6.getKey(), r6);
    }

    public IResolver get(String code) {
        return requestResolverMap.get(code);
    }

}
