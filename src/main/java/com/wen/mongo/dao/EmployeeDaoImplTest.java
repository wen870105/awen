/**
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.wen.mongo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDaoImpl    employeeDao;

    @Autowired
    private ApplicationContext context;

    @Test
    public void testFindAll() {
        List<Employee> list = employeeDao.findAll();
        for (Employee employee : list) {
            System.out.println("===" + employee);
        }
    }

    @Test
    public void testInsertOneEmployee() {
        Employee e = new Employee("admin12344", 28);
        employeeDao.insertOneEmployee(e);
    }

    @Test
    public void testDeleteOneEmployeeByName() {
        employeeDao.deleteOneEmployeeByName("admin");
    }

    @Test
    public void testDeleteOneEmployee() {
        Employee e = employeeDao.findByName("admin");
        employeeDao.deleteOneEmployee(e.getId());
    }

    @Test
    public void testFindByName() {
        Employee e = employeeDao.findByName("admin");
        System.out.println(e);
    }

    @Test
    public void testFind() {
        Employee e = employeeDao.findByName("admin");
        Employee e2 = employeeDao.find(e.getId());
        System.out.println(e2);
    }
}
