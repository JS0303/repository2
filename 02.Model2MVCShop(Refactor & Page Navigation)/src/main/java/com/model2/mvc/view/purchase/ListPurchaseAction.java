package com.model2.mvc.view.purchase;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class ListPurchaseAction extends Action {

	public ListPurchaseAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Search search = new Search();
		User user = (User)session.getAttribute("user");
		
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		String pageUnit = getServletContext().getInitParameter("pageSize");
		search.setPageSize(Integer.parseInt(pageUnit));
		search.setCurrentPage(page);
		
		String id = "";
		if(user != null) {
			id = user.getUserId();
		}
		
		PurchaseService purchaseService = new PurchaseServiceImpl();
		HashMap<String, Object> map = purchaseService.getPurchaseList(search, id);
		
		request.setAttribute("map", map);
		request.setAttribute("search", search);
		
		return "forward:/purchase/listPurchase.jsp";
	}
	
}
