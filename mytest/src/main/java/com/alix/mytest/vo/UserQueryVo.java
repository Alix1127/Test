package com.alix.mytest.vo;

/**
 * <pre>用户查询VO类, 用于存储页面查询条件, 不存入数据库 <pre>
 * @author Alix
 * @date 2017年12月19日 下午2:39:18
 */
public class UserQueryVo {
	
	/**
	 * 登录名
	 */
	private String loginName;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 状态    1:启用; 0:禁用
	 */
	private Integer status;

	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
