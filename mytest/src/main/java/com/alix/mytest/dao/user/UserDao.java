package com.alix.mytest.dao.user;

import java.util.List;

import com.alix.mytest.entity.User;
import com.alix.mytest.vo.UserQueryVo;

public interface UserDao {

	List<User> query(UserQueryVo uqv);

}
