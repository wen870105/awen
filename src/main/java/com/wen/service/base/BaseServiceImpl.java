package com.wen.service.base;

import java.util.List;

import com.wen.dao.base.BaseDao;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年5月20日
 */
/**
 * @author Wen
 * @CreatDate: 2016年5月20日
 * @param
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	@Override
	public T getById_(Long id) {
		return getDao().getById_(id);
	}

	@Override
	public void add_(T t) {
		getDao().add_(t);
	}

	@Override
	public int update_(T t) {
		return getDao().update_(t);
	}

	@Override
	public List<T> findList_(Object t) {
		return getDao().findList_(t);
	}

	@Override
	public void delete_(Long id) {
		getDao().delete_(id);
	}

	/**
	 * 子类重写
	 */
	@Override
	public BaseDao getDao() {
		throw new IllegalArgumentException("当前Service的BaseDao为空");
	}

}
