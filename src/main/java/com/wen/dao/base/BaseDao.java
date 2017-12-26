/*
 * Copyright (c) 2017-06-26 com.wen All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 * 2017-06-26 生成于wCodeMaker wnick123@gmail.com
 */
package com.wen.dao.base;

import java.util.List;

/**
 * 基础方法不建议修改,如需修改请修改对应的子类
 * @author wEn
 * @CreatDate: 2017-06-26 
 */
public interface BaseDao<T> {

	public void add(T t);
	
	public int deleteByIds(long[] ids);
	
	public int deleteByCondtion(T t);
	
	public int updateById(T t);
	
	public T selectById(long id);

	public T selectOne(T t);
	
	public List<T> selectList(T t);

	public int selectListCount(T t) ;
	
	public List<T> selectByIds(long[] ids) ;
}
