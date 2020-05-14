/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.wen.util;

import java.util.concurrent.atomic.AtomicReference;

/**
 * e.g.:
 * public static RateLimitFactory INSTANCE = new AbstractSingleton<RateLimitFactory>() {
        @Override
        protected RateLimitFactory newInstance() {
            return new RateLimitFactory();
        }
    }.get();
    
 * @author wsy48420
 * @version $Id: AbstractSingleton.java, v 0.1 2017年8月25日 下午2:26:34 wsy48420 Exp $
 */
public abstract class AbstractSingleton<T> {
    private final AtomicReference<T> ref = new AtomicReference<T>();

    public T get() {
        T ret = ref.get();
        if (ret == null) {
            T obj = newInstance();
            boolean b = ref.compareAndSet(null, obj);
            if (b) {
                return obj;
            } else {
                return ref.get();
            }
        }
        return ret;
    }

    protected abstract T newInstance();
}