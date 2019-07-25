package com.wen.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wen.domain.UserTest;
import com.wen.service.UserTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class DaoTest1 {

    @Autowired
    private UserTestService userTestService;

    @Test
    public void test1() {
        UserTest byName = userTestService.getByName("test");
        System.out.println(JSON.toJSONString(byName));
        assertTrue(byName != null);
    }
}
