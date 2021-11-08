package com.model2.mvc.common;


public class Page {
	
	///Field
	private int currentPage;		// 현재페이지
	private int totalCount;		// 총 게시물 수
	private int pageUnit;			// 하단 페이지 번호 화면에 보여지는 수
	private int pageSize;			// 한 페이지당 보여지는 게시물수
	private int maxPage;			// 최대 페이지 번호(전체 페이지)
	private int beginUnitPage;	//화면에 보여지는 페이지 번호의 최소수
	private int endUnitPage;	//화면에 보여지는 페이지 번호의 최대수
	
	///Constructor
	public Page() {
	}
	public Page( int currentPage, int totalCount,	int pageUnit, int pageSize ) {
		this.totalCount = totalCount;
		this.pageUnit = pageUnit;
		this.pageSize = pageSize;
		
		this.maxPage = (pageSize == 0) ? totalCount :  (totalCount-1)/pageSize +1;
		this.currentPage = ( currentPage > maxPage) ? maxPage : currentPage;
		
		this.beginUnitPage = ( (currentPage-1) / pageUnit ) * pageUnit +1 ;
		
		if( maxPage <= pageUnit ){
			this.endUnitPage = maxPage;
		}else{
			this.endUnitPage = beginUnitPage + (pageUnit -1);
			if( maxPage <= endUnitPage){
				this.endUnitPage = maxPage;
			}
		}
	}
	
	///Mehtod
	public int getCurrentPage() {
		System.out.println(":: Page.java의 currentPage :: "+currentPage);
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		System.out.println(":: Page.java의 currentPage :: "+currentPage);
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		System.out.println(":: Page.java의 totalCount :: "+totalCount);
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		System.out.println(":: Page.java의 totalCount :: "+totalCount);
		this.totalCount = totalCount;
	}
	public int getPageUnit() {
		System.out.println(":: Page.java의 pageUnit :: "+pageUnit);
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		System.out.println(":: Page.java의 pageUnit :: "+pageUnit);
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		System.out.println(":: Page.java의 pageSize :: "+pageSize);
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		System.out.println(":: Page.java의 pageSize :: "+pageSize);
		this.pageSize = pageSize;
	}
	public int getMaxPage() {
		System.out.println(":: Page.java의 maxPage :: "+maxPage);
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		System.out.println(":: Page.java의 maxPage :: "+maxPage);
		this.maxPage = maxPage;
	}
	public int getBeginUnitPage() {
		System.out.println(":: Page.java의 beginUnitPage :: "+beginUnitPage);
		return beginUnitPage;
	}
	public void setBeginUnitPage(int beginUnitPage) {
		System.out.println(":: Page.java의 beginUnitPage :: "+beginUnitPage);
		this.beginUnitPage = beginUnitPage;
	}
	public int getEndUnitPage() {
		System.out.println(":: Page.java의 endUnitPage :: "+endUnitPage);
		return endUnitPage;
	}
	public void setEndUnitPage(int endUnitPage) {
		System.out.println(":: Page.java의 endUnitPage :: "+endUnitPage);
		this.endUnitPage = endUnitPage;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalCount="
				+ totalCount + ", pageUnit=" + pageUnit + ", pageSize="
				+ pageSize + ", maxPage=" + maxPage + ", beginUnitPage="
				+ beginUnitPage + ", endUnitPage=" + endUnitPage + "]";
	}
}