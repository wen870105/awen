package com.wen.dao.base;

import java.util.List;

/**
 * 默认带下划线的方法都和mybaits.xml对应
 * @author Wen
 * @CreatDate: 2016年5月9日
 */
public interface BaseDao {
	public <T> T getById_(Long id);

	public <T> void add_(T t);

	public <T> int update_(T t);

	public void delete_(Long id);

	public <T> List<T> findList_(Object t);

}
