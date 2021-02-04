package com.ntuc.model;

import java.util.List;
import javax.annotation.Generated;
import java.util.Collections;



public class SettingsGroup {

    private String group;

    private List<Setting> settingList;

	@Generated("SparkTools")
	private SettingsGroup(Builder builder) {
		this.group = builder.group;
		this.settingList = builder.settingList;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public List<Setting> getSettingList() {
		return settingList;
	}

	public void setSettingList(List<Setting> settingList) {
		this.settingList = settingList;
	}

	public SettingsGroup(String group, List<Setting> settingList) {
		super();
		this.group = group;
		this.settingList = settingList;
	}
    
	public SettingsGroup() {}

	/**
	 * Creates builder to build {@link SettingsGroup}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link SettingsGroup}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String group;
		private List<Setting> settingList = Collections.emptyList();

		private Builder() {
		}

		public Builder group(String group) {
			this.group = group;
			return this;
		}

		public Builder settingList(List<Setting> settingList) {
			this.settingList = settingList;
			return this;
		}

		public SettingsGroup build() {
			return new SettingsGroup(this);
		}
	}
	
	
}
