package com.ntuc.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import javax.annotation.Generated;


public class Car {

    private String vin;
    private Color color;
    private String model;
    private Date productionDate;
	@Generated("SparkTools")
	private Car(Builder builder) {
		this.vin = builder.vin;
		this.color = builder.color;
		this.model = builder.model;
		this.productionDate = builder.productionDate;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	/**
	 * Creates builder to build {@link Car}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link Car}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String vin;
		private Color color;
		private String model;
		private Date productionDate;

		private Builder() {
		}

		public Builder vin(String vin) {
			this.vin = vin;
			return this;
		}

		public Builder color(Color color) {
			this.color = color;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Builder productionDate(Date productionDate) {
			this.productionDate = productionDate;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
    
    
}
