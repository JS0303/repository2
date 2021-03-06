package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;

public class PurchaseDAO {

	/// Constructor
	public PurchaseDAO() {
	}

	/// Method
	public Purchase findPurchase(int no) throws Exception {

		Connection con = DBUtil.getConnection();

		PreparedStatement stmt = null;

		StackTraceElement[] stacks = new Throwable().getStackTrace();

		StackTraceElement beforeStack = stacks[1];
		System.out.println("실행된 메소드 :: " + beforeStack.getMethodName());

		String sql = "select * from TRANSACTION where ";

		if (beforeStack.getMethodName().contains("2")) {
			sql += "prod_no = '" + no + "'";
		} else {
			sql += "tran_no = '" + no + "'";
		}

		System.out.println("findPurchase 메소드의 준비된 sql :: " + sql);
		stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		System.out.println("::findPurchase 쿼리전송");

		Purchase purchase = new Purchase();
		Product product = new Product();
		User user = new User();

		if (rs.next()) {
			purchase.setTranNo(rs.getInt(1));
			product.setProdNo(rs.getInt(2));
			user.setUserId(rs.getString(3));
			purchase.setPaymentOption(rs.getString(4));
			purchase.setReceiverName(rs.getString(5));
			purchase.setReceiverPhone(rs.getString(6));
			purchase.setDlvyAddr(rs.getString(7));
			purchase.setDlvyRequest(rs.getString(8));
			purchase.setTranCode(rs.getString(9));
			purchase.setOrderDate(rs.getDate(10));

			if (rs.getString(11) != null) {
				purchase.setDlvyDate(rs.getString(11));
			} else {
				purchase.setDlvyDate("");
			}

			purchase.setPurchaseProd(product);
			purchase.setBuyer(user);
		}

		stmt.close();
		rs.close();
		con.close();

		return purchase;
	}

	public HashMap<String, Object> getPurchaseList(Search search, String buyerId) throws Exception {

		Connection con = DBUtil.getConnection();

		String sql = "select * from TRANSACTION " + "where BUYER_ID = ?";

		HashMap<String, Object> map = new HashMap<String, Object>();

		PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		stmt.setString(1, buyerId);
		System.out.println("buyerId :: "+buyerId);

		ResultSet rs = stmt.executeQuery();
		rs.last();

		// 총 row 수를 얻는다
		int total = rs.getRow();
		System.out.println("getPurchaseList의 총 row수 :: " + total);

		map.put("count", new Integer(total));
		rs.absolute(search.getCurrentPage() * search.getPageSize() - search.getPageSize() + 1);
		System.out.println("getPurchseList의 searchVO.getPage()::" + search.getCurrentPage());
		System.out.println("getPurchseList의 searchVO.getPageUnit()::" + search.getPageSize());

		List<Purchase> list = new ArrayList<Purchase>();
		if (total > 0) {
			for (int i = 0; i < search.getPageSize(); i++) {
				Purchase purchase = new Purchase();
				Product product = new Product();
				User user = new User();

				purchase.setTranNo(rs.getInt(1));
				product.setProdNo(rs.getInt(2));
				user.setUserId(rs.getString(3));
				purchase.setPaymentOption(rs.getString(4));
				purchase.setReceiverName(rs.getString(5));
				purchase.setReceiverPhone(rs.getString(6));
				purchase.setDlvyAddr(rs.getString(7));
				purchase.setDlvyRequest(rs.getString(8));
				purchase.setTranCode(rs.getString(9));
				purchase.setOrderDate(rs.getDate(10));
				purchase.setDlvyDate(rs.getString(11));

				purchase.setPurchaseProd(product);
				purchase.setBuyer(user);

				list.add(purchase);
				if (!rs.next()) {
					break;
				}
			}
		}

		map.put("list", list);

		rs.close();
		stmt.close();
		con.close();

		return map;
	}

	public HashMap<String, Object> getSaleList(Search search) throws Exception {

		return null;
	}

	public void insertPurchase(Purchase purchase) throws Exception {

		Connection con = DBUtil.getConnection();

		String sql = "insert into TRANSACTION values (seq_transaction_tran_no.nextval,?,?,?,?,?,?,?,?,sysdate,?)";

		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setInt(1, purchase.getPurchaseProd().getProdNo());
		stmt.setObject(2, purchase.getBuyer().getUserId());
		stmt.setString(3, purchase.getPaymentOption());
		stmt.setString(4, purchase.getReceiverName());
		stmt.setString(5, purchase.getReceiverPhone());
		stmt.setString(6, purchase.getDlvyAddr());
		stmt.setString(7, purchase.getDlvyRequest());
		stmt.setString(8, purchase.getTranCode());
		stmt.setString(9, null);
		System.out.println(":: PurchaseDAO의 준비된 insertPurchase sql ::" + sql);

		System.out.println(purchase.getPurchaseProd() + " :: PurchaseDAO의 insertPurchase에서 찍은 PurchaseProd");

		if (!"".equals(purchase.getDlvyDate())) {
			stmt.setDate(9, Date.valueOf(purchase.getDlvyDate()));
		}

		if (stmt.executeUpdate() == 1) {
			System.out.println("구매등록완료");
		} else {
			System.out.println("구매등록실패");
		}

		stmt.close();

		con.close();
	}

	public void updatePurcahse(Purchase purchase) throws Exception {

		Connection con = DBUtil.getConnection();

		String sql = "update TRANSACTION " + "set PAYMENT_OPTION=?, RECEIVER_NAME=?, RECEIVER_PHONE=?, "
				+ "DEMAILADDR=?, DLVY_REQUEST=?, DLVY_DATE=? " + "where TRAN_NO=?";

		PreparedStatement stmt = con.prepareStatement(sql);
		System.out.println("updatePurchase의 sql :: "+sql);
		
		stmt.setString(1, purchase.getPaymentOption());
		stmt.setString(2, purchase.getReceiverName());
		stmt.setString(3, purchase.getReceiverPhone());
		stmt.setString(4, purchase.getDlvyAddr());
		stmt.setString(5, purchase.getDlvyRequest());
		stmt.setString(6, purchase.getDlvyDate());
		stmt.setInt(7, purchase.getTranNo());
		
		
		if(stmt.executeUpdate()==1) {
			System.out.println(":: Purchase Update 성공");
		}else {
			System.out.println(":: Purchase Update 실패");
		}
		
		stmt.close();
		con.close();
	}

	public void updateTranCode(Purchase purchase) throws Exception {
		
		Connection con = DBUtil.getConnection();
		System.out.println(purchase.getTranCode()+" "+purchase.getPurchaseProd().getProdNo());
		
		String sql = "update TRANSACTION " + "set TRAN_STATUS_CODE=? " + "where PROD_NO=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, purchase.getTranCode());
		stmt.setInt(2, purchase.getPurchaseProd().getProdNo());
		
		if(stmt.executeUpdate()==1) {
			System.out.println(":: Update TranCode 성공");
		}else {
			System.out.println(":: Update TranCode 실패");
		}
		
		con.close();
	}
}
