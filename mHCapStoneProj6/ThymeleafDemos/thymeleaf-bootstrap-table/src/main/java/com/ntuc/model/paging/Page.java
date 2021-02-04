package com.ntuc.model.paging;

import java.util.List;


public class Page<T> {
    List<T> content;
    int totalPages;
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Page(List<T> content, int totalPages) {
		super();
		this.content = content;
		this.totalPages = totalPages;
	}
    
    
}
