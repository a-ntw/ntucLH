package com.ntuc.employee.model;

import lombok.Builder;
import lombok.Getter;
import javax.annotation.Generated;

@Getter
@Builder
public class Employee {

    private String name;
    private Double salary;
    private EmployeePosition position;
	@Generated("SparkTools")
	private Employee(Builder builder) {
		this.name = builder.name;
		this.salary = builder.salary;
		this.position = builder.position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public EmployeePosition getPosition() {
		return position;
	}
	public void setPosition(EmployeePosition position) {
		this.position = position;
	}
	/**
	 * Creates builder to build {@link Employee}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link Employee}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String name;
		private Double salary;
		private EmployeePosition position;

		private Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder salary(Double salary) {
			this.salary = salary;
			return this;
		}

		public Builder position(EmployeePosition position) {
			this.position = position;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}
    
    
}
