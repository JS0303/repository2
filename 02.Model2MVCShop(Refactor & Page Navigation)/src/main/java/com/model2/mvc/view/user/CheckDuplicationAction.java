package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;


public class CheckDuplicationAction extends Action{

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {

		String userId=request.getParameter("userId");
		
		UserService userService=new UserServiceImpl();
		boolean result=userService.checkDuplication(userId);
		
		request.setAttribute("result",new Boolean(result) );
		request.setAttribute("userId", userId);
		
		System.out.println(":: CheckDuplicationAction :: Id가 중복되지 않도록 체크하는 action : checkDuplication.jsp로 보낸다");
		return "forward:/user/checkDuplication.jsp";
	}
}