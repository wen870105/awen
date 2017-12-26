/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.wen.web.validation;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author wsy48420
 * @version $Id: User.java, v 0.1 2017年8月15日 下午5:45:58 wsy48420 Exp $
 */
public class User {
    private String name;
    @NotEmpty(message = "用户名不能为空")
    private String pwd;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date123;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getDate123() {
        return date123;
    }

    public void setDate123(Date date123) {
        this.date123 = date123;
    }
    
}
