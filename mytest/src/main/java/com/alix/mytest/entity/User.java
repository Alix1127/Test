package com.alix.mytest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alix.mytest.constants.Constants;

/**
 *<pre>用户实体<pre>
 * @author Alix
 * @date 2017年12月19日 下午2:09:14
 */
@Entity
@Table(name="mytest_sys_user", schema=Constants.MYTEST)
@SequenceGenerator(allocationSize=1, name="MYTEST_SYS_USER", sequenceName="MYTEST_SYS_USER_SEQ")
public class User extends BaseEntity{

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 6279845876301033977L;

	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 密码(密文)
	 */
	private String password;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 状态    1:启用(默认值); 0:禁用;
	 */
	private Integer status;
	
	/**
	 * 用户新增日期(yyyy-MM-dd HH24:mm:ss)
	 */
	private Date addDate;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MYTEST_SYS_USER")
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="login_name")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="add_date")
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
