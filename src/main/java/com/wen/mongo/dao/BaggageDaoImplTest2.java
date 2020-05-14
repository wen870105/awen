/**
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.wen.mongo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author wsy48420
 * @version $Id: TT.java, v 0.1 2019年7月8日 下午8:36:31 wsy48420 Exp $
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class BaggageDaoImplTest2 {

    @Autowired
    private BaggageDaoImpl baggageDao;

    @Test
    public void testFindAll() {
        //        List<Baggage> list = baggageDao.findAll();
        //        for (Baggage b : list) {
        //            System.out.println("===" + b);
        //        }
        //        System.out.println("=================aaa="+1111);
    }

    @Test
    public void testFindByCondiction() {
        BaggageQuery query = new BaggageQuery();
        query.setDepAirportCode("HKG5");
        //        query.setCarrier("CA1");
        query.setArrAirportCode("PVG6");

        Baggage bag = new Baggage();
        BeanUtils.copyProperties(query, bag);
        System.out.println("=================ccccaa=" + bag);
        List<Baggage> list = baggageDao.findByCondiction(bag);
        System.out.println("total:" + list.size());
        for (Baggage b : list) {
            System.out.println("===" + b);
        }
    }

    //    @Test
    //    public void testInsertOneEmployee() {
    //        Baggage bag = new Baggage();
    //
    //        bag.setCarrier("CA1");
    //        bag.setDepAirport("HKG5");
    //        bag.setDepAirportCode("HKG5");
    //        bag.setArrAirportCode("PVG6");
    //        bag.setArrAirport("PVG6");
    //        System.out.println("=================aaa="+bag);
    //        baggageDao.insertOneEmployee(bag);
    //    }
}
