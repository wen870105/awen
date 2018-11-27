/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.tcshare.generic.demo.t1;

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
public class INBResolverRegistry2 extends AbstractResolverRegistry<String, IHandler>{
    private Map<String, IResolver> requestResolverMap = new HashMap<>();

    @Override
    protected Class<IHandler> getResolverClass() {
        return IHandler.class;
    }

    
    public static void main(String[] args) {
        
    }
}
