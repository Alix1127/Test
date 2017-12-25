package com.alix.mytest.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alix.mytest.dao.user.UserDao;
import com.alix.mytest.entity.User;
import com.alix.mytest.service.base.BaseService;
import com.alix.mytest.vo.UserQueryVo;

@Component
@Transactional(readOnly=true)
public class UserService extends BaseService<User>{

	@Autowired
	private UserDao userDao;
	
	public List<User> query(UserQueryVo uqv) {
		return this.userDao.query(uqv);
	}

}
