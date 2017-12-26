/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.test.serializable;

import java.io.Serializable;

/**
 * 
 * @author wsy48420
 * @version $Id: Son.java, v 0.1 2017年11月7日 下午4:09:59 wsy48420 Exp $
 */
public class Son implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
