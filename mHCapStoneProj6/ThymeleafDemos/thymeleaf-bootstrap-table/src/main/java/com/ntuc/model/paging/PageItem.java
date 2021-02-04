package com.ntuc.model.paging;

import javax.annotation.Generated;




public class PageItem {

    private PageItemType pageItemType;

    private int index;

    private boolean active;

	@Generated("SparkTools")
	private PageItem(Builder builder) {
		this.pageItemType = builder.pageItemType;
		this.index = builder.index;
		this.active = builder.active;
	}

	public PageItemType getPageItemType() {
		return pageItemType;
	}

	public void setPageItemType(PageItemType pageItemType) {
		this.pageItemType = pageItemType;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Creates builder to build {@link PageItem}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link PageItem}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private PageItemType pageItemType;
		private int index;
		private boolean active;

		private Builder() {
		}

		public Builder withPageItemType(PageItemType pageItemType) {
			this.pageItemType = pageItemType;
			return this;
		}

		public Builder withIndex(int index) {
			this.index = index;
			return this;
		}

		public Builder withActive(boolean active) {
			this.active = active;
			return this;
		}

		public PageItem build() {
			return new PageItem(this);
		}
	}

}
