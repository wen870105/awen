package com.wen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wen.dao.ExportWenDao;
import com.wen.dao.base.BaseDao;
import com.wen.domain.ExportWen;
import com.wen.service.base.BaseServiceImpl;
/**
 * 
 * @author Wen
 * @since 2017-01-18
 */
@Service("exportWenService")
public class ExportWenServiceImpl extends BaseServiceImpl<ExportWen> implements ExportWenService {

	@Autowired
	private ExportWenDao exportWenDao;

	@Override
	public BaseDao getDao() {
		return exportWenDao;
	}
	
}
