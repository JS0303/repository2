<%@ page contentType="text/html; charset=EUC-KR"%>

<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.domain.Purchase"%>
<%@ page import="com.model2.mvc.common.*" %>
<%@ page import="com.model2.mvc.service.domain.User" %>
<%@ page import="com.model2.mvc.service.domain.Product" %>
<%@ page import="com.model2.mvc.service.purchase.dao.*" %>

<%
	User user = (User)request.getAttribute("user");
		System.out.println(getClass().getName()+"addPurchase.jsp에서 불러온 userVO : "+user);
		
	Product product = (Product)request.getAttribute("product");
		System.out.println(getClass().getName()+"addPurchase.jsp에서 불러온 productVO : "+product);
		
	Purchase purchase=(Purchase)request.getAttribute("purchase");
		System.out.println(getClass().getName()+"addPurchase.jsp에서 불러온 purchaseVO : "+purchase);
		
	String payment = "신용구매";
%>




<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=<%=purchase.getTranNo() %>" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td><%=purchase.getPurchaseProd().getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td><%=purchase.getBuyer().getUserId() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		
			<%=purchase.getPaymentOption() %>
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td><%=purchase.getReceiverName() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td><%=purchase.getReceiverPhone() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td><%=purchase.getDlvyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td><%=purchase.getDlvyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td><%=purchase.getDlvyDate() %></td>
		<td></td>
	</tr>
	<tr>
		<td>주문상태코드</td>
		<td><%=purchase.getTranCode() %></td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>