<%@ page contentType="text/html; charset=EUC-KR"%>

<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.domain.Purchase"%>
<%@ page import="com.model2.mvc.common.*" %>
<%@ page import="com.model2.mvc.service.domain.User" %>
<%@ page import="com.model2.mvc.service.domain.Product" %>
<%@ page import="com.model2.mvc.service.purchase.dao.*" %>

<%
	User user = (User)request.getAttribute("user");
		System.out.println(getClass().getName()+"addPurchase.jsp���� �ҷ��� userVO : "+user);
		
	Product product = (Product)request.getAttribute("product");
		System.out.println(getClass().getName()+"addPurchase.jsp���� �ҷ��� productVO : "+product);
		
	Purchase purchase=(Purchase)request.getAttribute("purchase");
		System.out.println(getClass().getName()+"addPurchase.jsp���� �ҷ��� purchaseVO : "+purchase);
		
	String payment = "�ſ뱸��";
%>




<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=<%=purchase.getTranNo() %>" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td><%=purchase.getPurchaseProd().getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td><%=purchase.getBuyer().getUserId() %></td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
		
			<%=purchase.getPaymentOption() %>
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td><%=purchase.getReceiverName() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td><%=purchase.getReceiverPhone() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td><%=purchase.getDlvyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td><%=purchase.getDlvyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td><%=purchase.getDlvyDate() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�ֹ������ڵ�</td>
		<td><%=purchase.getTranCode() %></td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>