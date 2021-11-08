package com.model2.mvc.common;


public class Page {
	
	///Field
	private int currentPage;		// ����������
	private int totalCount;		// �� �Խù� ��
	private int pageUnit;			// �ϴ� ������ ��ȣ ȭ�鿡 �������� ��
	private int pageSize;			// �� �������� �������� �Խù���
	private int maxPage;			// �ִ� ������ ��ȣ(��ü ������)
	private int beginUnitPage;	//ȭ�鿡 �������� ������ ��ȣ�� �ּҼ�
	private int endUnitPage;	//ȭ�鿡 �������� ������ ��ȣ�� �ִ��
	
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
		System.out.println(":: Page.java�� currentPage :: "+currentPage);
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		System.out.println(":: Page.java�� currentPage :: "+currentPage);
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		System.out.println(":: Page.java�� totalCount :: "+totalCount);
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		System.out.println(":: Page.java�� totalCount :: "+totalCount);
		this.totalCount = totalCount;
	}
	public int getPageUnit() {
		System.out.println(":: Page.java�� pageUnit :: "+pageUnit);
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		System.out.println(":: Page.java�� pageUnit :: "+pageUnit);
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		System.out.println(":: Page.java�� pageSize :: "+pageSize);
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		System.out.println(":: Page.java�� pageSize :: "+pageSize);
		this.pageSize = pageSize;
	}
	public int getMaxPage() {
		System.out.println(":: Page.java�� maxPage :: "+maxPage);
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		System.out.println(":: Page.java�� maxPage :: "+maxPage);
		this.maxPage = maxPage;
	}
	public int getBeginUnitPage() {
		System.out.println(":: Page.java�� beginUnitPage :: "+beginUnitPage);
		return beginUnitPage;
	}
	public void setBeginUnitPage(int beginUnitPage) {
		System.out.println(":: Page.java�� beginUnitPage :: "+beginUnitPage);
		this.beginUnitPage = beginUnitPage;
	}
	public int getEndUnitPage() {
		System.out.println(":: Page.java�� endUnitPage :: "+endUnitPage);
		return endUnitPage;
	}
	public void setEndUnitPage(int endUnitPage) {
		System.out.println(":: Page.java�� endUnitPage :: "+endUnitPage);
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