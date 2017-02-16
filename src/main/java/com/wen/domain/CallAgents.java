package com.wen.domain;

import java.util.Date;

/**
 * 
 * @author Wen
 * @since 2016-10-27
 */
public class CallAgents {
	// 
	private Long id;
	// 
	private Long agentId;
	private String agentName;
	// 账户编号
	private String accountid;
	// 
	private String state;
	// 账户token
	private String token;
	// voip账号
	private String voip;
	// voip密码
	private String password;
	// 创建时间
	private Date createTime;
	// 创建人
	private String createUser;
	// 
	private Date updateTime;
	// 
	private String updateUser;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setVoip(String voip) {
		this.voip = voip;
	}

	public String getVoip() {
		return voip;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
}