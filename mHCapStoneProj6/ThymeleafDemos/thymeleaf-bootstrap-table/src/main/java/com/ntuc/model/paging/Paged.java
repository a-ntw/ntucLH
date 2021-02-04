package com.ntuc.model.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Paged<T> {

    private Page<T> page;

    private Paging paging;

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public Paged(Page<T> page, Paging paging) {
		super();
		this.page = page;
		this.paging = paging;
	}

	public Paged() {
	}

}
