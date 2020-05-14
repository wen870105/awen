/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.tcshare.reflect.resourcedemo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author wsy48420
 * @version $Id: ResourceData.java, v 0.1 2018年1月5日 下午3:49:35 wsy48420 Exp $
 */
public class ResourceData {

    private String internationalUrl;

    private String internalUrl;

    private String pid;

    private String securityCode;

    @ResAnt("ext111")
    private String ext;

    public String getInternationalUrl() {
        return internationalUrl;
    }

    public void setInternationalUrl(String internationalUrl) {
        this.internationalUrl = internationalUrl;
    }

    public String getInternalUrl() {
        return internalUrl;
    }

    public void setInternalUrl(String internalUrl) {
        this.internalUrl = internalUrl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
