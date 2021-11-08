package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;


public class UpdateUserAction extends Action {

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		String userId=(String)request.getParameter("userId");
		
		User user=new User();
		user.setUserId(userId);
		user.setUserName(request.getParameter("userName"));
		user.setAddr(request.getParameter("addr"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		
		UserService userService=new UserServiceImpl();
		userService.updateUser(user);
		
		HttpSession session=request.getSession();
		String sessionId=((User)session.getAttribute("user")).getUserId();
		
		if(sessionId.equals(userId)){
			session.setAttribute("user", user);
		}
		
		System.out.println(":: UpdateUserAction :: User에 회원정보를 담아 session에 담긴 userId와 일치할 경우 화면에 회원정보를 보여준다.");
		return "redirect:/getUser.do?userId="+userId;
	}
}