/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.tcshare.generic.demo.t1;

/**
 * 解析器
 * 
 * @author wsy48420
 * @version $Id: IResolver.java, v 0.1 2017年10月16日 上午11:19:54 wsy48420 Exp $
 */
public interface IResolver<K> {

    /**
     * 注册器中的查找名称
     * 
     * @return
     */
    public K getKey();
}
