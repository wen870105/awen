/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.tcshare.generic.demo.t1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 同类型解析器抽象类
 * @author wsy48420
 * @version $Id: Abstract.java, v 0.1 2017年10月16日 上午10:50:30 wsy48420 Exp $
 */
public abstract class AbstractResolverRegistry<K, V extends IResolver<K>> implements ApplicationContextAware{
    protected Logger           logger      = LoggerFactory.getLogger(this.getClass());
    private Map<K, V>          resolverMap = new HashMap<>();

    private ApplicationContext ctx;

    public V getResolver(K k1) {
        return resolverMap.get(k1);
    }

    @PostConstruct
    private void init() {
        Class<V> clazz = getResolverClass();
        Collection<V> list = ctx.getBeansOfType(clazz).values();
        if (list != null) {
            list.forEach((v1) -> {
                resolverMap.put(v1.getKey(), v1);
            });
        }
        logger.info("初始化classType={},resolverRegistry.length={}", new Object[] { clazz, list != null ? list.size() : 0 });
    }

    /**
     * 注册器容器的类型
     * 
     * @return
     */
    protected abstract Class<V> getResolverClass();

    /** 
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}