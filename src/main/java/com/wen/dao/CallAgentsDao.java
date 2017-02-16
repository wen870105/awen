package com.wen.dao;

import com.wen.dao.base.BaseDao;
import com.wen.domain.CallAgents;

/**
 * 
 * @author Wen
 * @since 2016-10-27
 */
public interface CallAgentsDao extends BaseDao{
	public CallAgents findByAgentId(Long agentId);
}