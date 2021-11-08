package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		String prodNo=(String)request.getParameter("prodNo");
		System.out.println(":: UpdateProductAction.java�� prodNo :: "+prodNo);
		System.out.println(":: UpdateProductAction.java�� execute ����..");
		
		Product product=new Product();
		System.out.println(":: UpdateProductAction.java�� Product �����Ϸ�");
		product.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		product.setProdName(request.getParameter("prodName"));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setManuDate(request.getParameter("manuDate"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));
		System.out.println(":: UpdateProductAction.java�� product setting �Ϸ�");
		System.out.println(":: UpdateProductAction.java�� Product :: "+product);
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(product);
		
		HttpSession session=request.getSession();
//		String sessionId=((ProductVO)session.getAttribute("product")).getProdName();
//	
//		if(sessionId.equals(prodName)){
//			session.setAttribute("product", productVO);
		System.out.println("UpdateProductAction.java�� execute ����..");
//		}
		
		return "redirect:/getProduct.do?prodNo="+prodNo;
	}
}