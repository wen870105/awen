/**
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.wen.mongo.dao;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author wsy48420
 * @version $Id: Employee.java, v 0.1 2019年7月8日 下午8:34:41 wsy48420 Exp $
 */
@Document(collection = "employee")
public class Employee implements Serializable {

    @Id
    @Field(value = "_id")
    private String  id;

    @Field(value = "name")
    private String  name;

    @Field
    private Integer age;

    @Field
    private Date    createTime = new Date();

    public Employee() {
        super();
    }

    public Employee(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
