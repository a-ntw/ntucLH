package com.ntuc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.annotation.Generated;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settings {

    private List<SettingsGroup> groupList;

	@Generated("SparkTools")
	private Settings(Builder builder) {
		this.groupList = builder.groupList;
	}

	public List<SettingsGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<SettingsGroup> groupList) {
		this.groupList = groupList;
	}

	public Settings(List<SettingsGroup> groupList) {
		super();
		this.groupList = groupList;
	}
    
	public Settings() {}

	/**
	 * Creates builder to build {@link Settings}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Settings}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private List<SettingsGroup> groupList = Collections.emptyList();

		private Builder() {
		}

		public Builder groupList(List<SettingsGroup> groupList) {
			this.groupList = groupList;
			return this;
		}

		public Settings build() {
			return new Settings(this);
		}
	}
	
	
	
}
