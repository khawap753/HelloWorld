package com.myweb.util;

public class PageVO {

	private int endPage; // 게시믈 화면에  보여질 끝 페이지 번호
	private int startPage;
	private boolean prev;
	private boolean next;
	
	private int total;
	private int amount;
	private int pageNum;
	
	public PageVO(int pageNum, int total, int amount) {
		this.pageNum = pageNum;
		this.total = total;
		this.amount = amount;
		
		this.endPage = (int)Math.ceil(this.pageNum/ 10.0) * 10;
		
		this.startPage = endPage - 10 + 1;
		
		int realEnd = (int)Math.ceil(this.total / (double)this.amount );
		
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = realEnd > this.endPage;
		
		System.out.println("[endPage]" + this.endPage);
		System.out.println("[startPage]" + this.startPage);
	}
	
	// service 에서 게시글 조회 메서드 수정 하기.

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
