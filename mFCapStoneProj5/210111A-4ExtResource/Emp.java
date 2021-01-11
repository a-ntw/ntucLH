package com.cp5;

public class Emp {

	private String empName;
	private int empAge;
	private String empCountry;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpCountry() {
		return empCountry;
	}
	public void setEmpCountry(String empCountry) {
		this.empCountry = empCountry;
	}
	public Emp() {
		super();
	}
	public Emp(String empName, int empAge, String empCountry) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empCountry = empCountry;
	}
	@Override
	public String toString() {
		return "Emp [empName=" + empName + ", empAge=" + empAge + ", empCountry=" + empCountry + "]";
	}
	
	

}
