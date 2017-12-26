/*
 * Copyright (c) 2017-06-26 com.wen All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 * 2017-06-26 生成于wCodeMaker wnick123@gmail.com
 */
package com.wen.service;

import com.wen.domain.UserTest;
import com.wen.service.base.BaseService;

/**
 * 
 * @author Wen
 * @since 2017-06-26
 */
public interface UserTestService extends BaseService<UserTest> {
    UserTest getByName(String name);
}
 
