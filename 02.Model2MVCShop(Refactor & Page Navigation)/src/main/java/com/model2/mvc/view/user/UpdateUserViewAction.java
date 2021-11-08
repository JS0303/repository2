package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;


public class UpdateUserViewAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId=request.getParameter("userId");
		
		UserService userService=new UserServiceImpl();
		User user=userService.getUser(userId);
		
		request.setAttribute("user", user);
		
		System.out.println(":: UpdateUserViewAction :: userId를 parameter로 받아 service객체를 생성하고 User로부터 request의 상태값을 정한다.");
		return "forward:/user/updateUser.jsp";
	}
}