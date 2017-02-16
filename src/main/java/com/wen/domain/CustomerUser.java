package com.wen.domain;

import java.util.Date;

/**
 * 淘金客基础信息
 * @author Wen
 * @since 2016-10-27
 */
public class CustomerUser {
	// 淘金id
	private Long id;
	// 登录名
	private String loginName;
	// 登陆密码
	private String loginPwd;
	// 登陆头像
	private String head;
	// 昵称
	private String nick;
	// 真实姓名
	private String realName;
	// 性别
	private String sex;
	// 出生日期
	private String birthday;
	// 学历
	private String education;
	// 学校名称
	private String school;
	// 自我介绍
	private String introduction;
	// 登陆手机号
	private String loginPhone;
	// 绑定邮箱
	private String email;
	// 
	private String qq;
	// 账户类型
	private String accountType;
	// 提现账户
	private String cashAccount;
	// 用户状态(正常/锁定)
	private String userStatus;
	// 
	private String province;
	// 
	private String city;
	// 
	private String county;
	// 注册时间
	private Date registerTime;
	// 是否平台认证
	private String platformauth;
	// 支付账户
	private String paymentAccountId;
	// 
	private String isQqGroup;
	// 
	private String isPrintTest;
	// 推荐人的推荐码ID
	private Long referrerCodeId;
	// 
	private Integer expectedWorkType;
	// 
	private String idCardName;
	// 
	private String idCardNumber;
	// 
	private String idCardPositive;
	// 
	private String idCardOpposite;
	// 
	private String idCardWhole;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getHead() {
		return head;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return realName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducation() {
		return education;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public String getLoginPhone() {
		return loginPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQq() {
		return qq;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setCashAccount(String cashAccount) {
		this.cashAccount = cashAccount;
	}

	public String getCashAccount() {
		return cashAccount;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCounty() {
		return county;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setPlatformauth(String platformauth) {
		this.platformauth = platformauth;
	}

	public String getPlatformauth() {
		return platformauth;
	}

	public void setPaymentAccountId(String paymentAccountId) {
		this.paymentAccountId = paymentAccountId;
	}

	public String getPaymentAccountId() {
		return paymentAccountId;
	}

	public void setIsQqGroup(String isQqGroup) {
		this.isQqGroup = isQqGroup;
	}

	public String getIsQqGroup() {
		return isQqGroup;
	}

	public void setIsPrintTest(String isPrintTest) {
		this.isPrintTest = isPrintTest;
	}

	public String getIsPrintTest() {
		return isPrintTest;
	}

	public void setReferrerCodeId(Long referrerCodeId) {
		this.referrerCodeId = referrerCodeId;
	}

	public Long getReferrerCodeId() {
		return referrerCodeId;
	}

	public void setExpectedWorkType(Integer expectedWorkType) {
		this.expectedWorkType = expectedWorkType;
	}

	public Integer getExpectedWorkType() {
		return expectedWorkType;
	}

	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
	}

	public String getIdCardName() {
		return idCardName;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardPositive(String idCardPositive) {
		this.idCardPositive = idCardPositive;
	}

	public String getIdCardPositive() {
		return idCardPositive;
	}

	public void setIdCardOpposite(String idCardOpposite) {
		this.idCardOpposite = idCardOpposite;
	}

	public String getIdCardOpposite() {
		return idCardOpposite;
	}

	public void setIdCardWhole(String idCardWhole) {
		this.idCardWhole = idCardWhole;
	}

	public String getIdCardWhole() {
		return idCardWhole;
	}
}