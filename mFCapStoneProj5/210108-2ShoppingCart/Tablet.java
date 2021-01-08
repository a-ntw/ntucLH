package com.cp5;

public class Tablet extends Product {
	private int screenSize;

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public Tablet() {
		// TODO Auto-generated constructor stub
	}

	public Tablet(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [name=" + this.getName() + ", price=" + this.getPrice() + "]" +
		"Tablet [screenSize=" + screenSize + "]";
	}

}
