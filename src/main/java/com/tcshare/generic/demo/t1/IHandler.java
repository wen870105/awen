/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.tcshare.generic.demo.t1;

/**
 * 解析响应结果,转为api相关对象
 * @author wsy48420
 * @version $Id: Handler.java, v 0.1 2018年5月8日 下午5:02:26 wsy48420 Exp $
 */
public interface IHandler extends IResolver<String> {
    Object execute(Object req, String code);
}
