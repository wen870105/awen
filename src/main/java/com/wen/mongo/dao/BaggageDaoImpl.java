/**
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.wen.mongo.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author wsy48420
 * @version $Id: T.java, v 0.1 2019年7月8日 下午7:56:43 wsy48420 Exp $
 */
@Repository
public class BaggageDaoImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Baggage> findAll() {
        return mongoTemplate.findAll(Baggage.class);
    }

    public void insertOneEmployee(Baggage baggage) {
        mongoTemplate.insert(baggage);
    }

    public void deleteOne(String id) {
        Criteria c = new Criteria();
        c.and("_id").is(id);
        Query query = new Query(c);
        mongoTemplate.remove(query, Baggage.class);
    }

    public List<Baggage> findByCondiction(Baggage baggage) {
        Query query = new Query(buildCriteria(baggage));
        return mongoTemplate.find(query, Baggage.class);
    }

    public Baggage find(String id) {
        return mongoTemplate.findById(id, Baggage.class);
    }

    /**
     * 注意:
     * 新的查询条件需要修改下面逻辑
     * 目前不是通用写法
     * 
     * @param baggage
     * @return
     */
    private Criteria buildCriteria(Baggage bag) {
        Criteria c = new Criteria();
        if (StringUtils.isNotEmpty(bag.getCarrier())) {
            c.and("carrier").is(bag.getCarrier());
        }

        if (StringUtils.isNotEmpty(bag.getArrAirportCode())) {
            c.and("arr_airport_code").is(bag.getArrAirportCode());
        }

        if (StringUtils.isNotEmpty(bag.getDepAirportCode())) {
            c.and("dep_airport_code").is(bag.getDepAirportCode());
        }

        if (bag.getSaleType() != null) {
            c.and("sale_type").is(bag.getSaleType());
        }

        if (bag.getAvailable() != null) {
            c.and("available").is(bag.getAvailable());
        }

        if (StringUtils.isNotEmpty(bag.getFromSource())) {
            c.and("from_source").is(bag.getFromSource());
        }

        return c;
    }

    public static void main(String[] args) {
        Baggage bag = new Baggage();
        bag.setCarrier("CA");
        bag.setDepAirportCode("PVG");
        ClassTypeInformation<Baggage> info = ClassTypeInformation.from(Baggage.class);
        System.out.println();
    }
}