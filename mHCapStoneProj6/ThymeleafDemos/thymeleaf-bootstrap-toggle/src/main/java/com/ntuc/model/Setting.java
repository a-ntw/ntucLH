package com.ntuc.model;

import javax.annotation.Generated;

public class Setting {

    private String label;
    private boolean value;
	@Generated("SparkTools")
	private Setting(Builder builder) {
		this.label = builder.label;
		this.value = builder.value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public Setting(String label, boolean value) {
		super();
		this.label = label;
		this.value = value;
	}
    
	public Setting() {}
	/**
	 * Creates builder to build {@link Setting}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Setting}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String label;
		private boolean value;

		private Builder() {
		}

		public Builder label(String label) {
			this.label = label;
			return this;
		}

		public Builder value(boolean value) {
			this.value = value;
			return this;
		}

		public Setting build() {
			return new Setting(this);
		}
	}
	
	
}
