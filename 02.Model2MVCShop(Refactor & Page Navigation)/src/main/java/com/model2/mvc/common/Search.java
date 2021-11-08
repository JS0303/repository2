package com.model2.mvc.common;


public class Search {
	
	///Field
	private int curruntPage;
	private String searchCondition;
	private String searchKeyword;
	private int pageSize;
	
	///Constructor
	public Search() {
	}
	
	///Method
	public int getPageSize() {
		System.out.println(":: Search의 getPageSize :: "+pageSize);
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		System.out.println(":: Search의 setPageSize :: "+pageSize);
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		System.out.println(":: Search의 getCurrentPage :: "+curruntPage);
		return curruntPage;
	}
	public void setCurrentPage(int curruntPage) {
		System.out.println(":: Search의 setCurrentPage :: "+curruntPage);
		this.curruntPage = curruntPage;
	}

	public String getSearchCondition() {
		System.out.println(":: Search의 getSearchCondition :: "+searchCondition);
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		System.out.println(":: Search의 setSearchCondition :: "+searchCondition);
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		System.out.println(":: Search의 getSearchKeyword :: "+searchKeyword);
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		System.out.println(":: Search의 setSearchKeyword :: "+searchKeyword);
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "Search [curruntPage=" + curruntPage + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword
				+ ", pageSize=" + pageSize + "]";
	}
}