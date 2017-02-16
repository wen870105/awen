package com.wen.dao;

import com.wen.dao.base.BaseDao;
import com.wen.domain.CustomerUser;

/**
 * 
 * @author Wen
 * @since 2016-10-27
 */
public interface CustomerUserDao extends BaseDao {
	public CustomerUser findByName(String name);
}