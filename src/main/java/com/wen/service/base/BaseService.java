package com.wen.service.base;

import java.util.List;

import com.wen.dao.base.BaseDao;
import com.wen.domain.base.BaseDomain;
import com.wen.domain.base.Page;


/**
 * 默认带下划线的方法都和mybaits.xml对应
 * @author Wen
 * @CreatDate: 2016年5月20日
 */
public interface BaseService<T>{
	public T getById_(Long id);

	public void add_(T t);

	public int update_(T t);

	public void delete_(Long id);

	public List<T> findList_(Object t);
	
	public BaseDao getDao();
	
	public <P extends BaseDomain> Page<T> queryPage(P params);
}
