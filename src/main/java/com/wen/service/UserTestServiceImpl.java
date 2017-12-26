/*
 * Copyright (c) 2017-06-26 com.wen All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 * 2017-06-26 生成于wCodeMaker wnick123@gmail.com
 */
package com.wen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wen.dao.UserTestDao;
import com.wen.dao.base.BaseDao;
import com.wen.domain.UserTest;
import com.wen.service.base.BaseServiceImpl;
/**
 * 
 * @author Wen
 * @since 2017-06-26
 */
@Service("userTestService")
public class UserTestServiceImpl extends BaseServiceImpl<UserTest> implements UserTestService {

	@Autowired
	private UserTestDao userTestDao;

	@Override
    public BaseDao<UserTest> getDao() {
		return userTestDao;
	}

    /** 
     * @see com.wen.service.UserTestService#getByName(java.lang.String)
     */
    @Override
    public UserTest getByName(String name) {
        UserTest ut = new UserTest();
        ut.setName(name);
        return this.selectOne(ut);
    }
	
	
	
}
