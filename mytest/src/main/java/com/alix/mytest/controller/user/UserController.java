package com.alix.mytest.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alix.mytest.entity.User;
import com.alix.mytest.service.user.UserService;
import com.alix.mytest.vo.UserQueryVo;

/**
 * <pre>用户模块控制层<pre>
 * @author Alix
 * @date 2017年12月19日 下午2:37:09
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Model model) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/index";
	}
	
	/**
	 * <pre>列表展示查询方法<pre>
	 * @param request
	 * @param model
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:37:33
	 */
	@RequestMapping(value = "/query")
	public ModelAndView list(UserQueryVo uqv, HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
//			List<User> allUserList = this.userService.findAll(User.class);
			List<User> userList = this.userService.query(uqv);
//			User u = this.userService.findById(5L, User.class);
//			u.setPassword("123456");
//			User user = this.userService.update(u);
//			this.userService.delete(user);
//			User user = new User();
//			user.setLoginName("lisi");
//			user.setPassword("222222");
//			user.setUserName("李四");
//			user.setStatus(1);
//			user.setAddDate(new Date());
//			this.userService.save(user);
//			Long id = user.getId();
			map.put("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/user/list", map);
	}
}
