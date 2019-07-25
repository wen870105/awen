/**
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.wen.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author wsy48420
 * @version $Id: T.java, v 0.1 2019年7月8日 下午7:56:43 wsy48420 Exp $
 */
@Repository
public class EmployeeDaoImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class);
    }

    public void insertOneEmployee(Employee employee) {
        mongoTemplate.insert(employee);
    }

    public void deleteOneEmployeeByName(String name) {
        Criteria c = new Criteria();
        c.and("name").is(name);
        Query query = new Query(c);
        mongoTemplate.remove(query, Employee.class);
    }

    public void deleteOneEmployee(String id) {
        Criteria c = new Criteria();
        c.and("_id").is(id);
        Query query = new Query(c);
        mongoTemplate.remove(query, Employee.class);
    }

    public Employee findByName(String name) {
        Criteria c = new Criteria();
        c.and("name").is(name);
        Query query = new Query(c);
        return mongoTemplate.findOne(query, Employee.class);
    }

    public Employee find(String id) {
        return mongoTemplate.findById(id, Employee.class);
    }
}