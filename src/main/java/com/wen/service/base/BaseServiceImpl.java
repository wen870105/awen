package com.wen.service.base;

import java.util.List;

import com.wen.dao.base.BaseDao;
import com.wen.domain.base.BaseDomain;
import com.wen.domain.base.Page;

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

	@Override
	public <P extends BaseDomain> Page<T> queryPage(P params) {
		params.initPagination();
		int total = getDao().queryPageCount(params);
		List<T> list = getDao().queryPage(params);
		Page<T> page = new Page<T>();
		page.setResult(list);
		page.setTotalCount(total);
		page.setCurrentPage(params.getCurrPage());
		return page;
	}

}
