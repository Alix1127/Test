package com.alix.mytest.dao.user;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.alix.mytest.dao.base.BaseDaoImpl;
import com.alix.mytest.entity.User;
import com.alix.mytest.vo.UserQueryVo;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> query(UserQueryVo uqv) {
		StringBuffer sql = new StringBuffer();
		sql.append("  select u.*                         ");
		sql.append("    from mytest_sys_user u              ");
		sql.append("   where 1=1 					     ");
		if (uqv != null && uqv.getLoginName() != null) {
			sql.append("     and u.login_name = :loginName    ");
		}
		if (uqv != null && uqv.getUserName() != null) {
			sql.append("     and u.user_name = :userName      ");
		}
		if (uqv != null && uqv.getStatus() != null) {
			sql.append("     and u.status = :status          ");
		}

		SQLQuery query = getSession().createSQLQuery(sql.toString());
		if (uqv != null && uqv.getLoginName() != null) {
			query.setParameter("loginName", uqv.getLoginName()); 
		}
		if (uqv != null && uqv.getUserName() != null) {
			query.setParameter("userName", uqv.getUserName());
		}
		if (uqv != null && uqv.getStatus() != null) {
			query.setParameter("status", uqv.getStatus());
		}
		
		query.addEntity("u", User.class);
		List<User> userList = query.list();
		return userList;
	}

}
