package com.cp5;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTID")
	private long custId;
	
	@Column(name = "CUSTNAME")
	@Size(min = 8, max = 50)
	@NotNull
	private String custName;
	
	@Column(name = "DOB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(name = "EMAIL")
	@Size(min= 8 , max= 50)
	@NotNull
	@Email(message = "Please provide a valid email address !!!")
	private String email;
	
	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name = "PHONENO")
	@NotNull
	@Size(min=8, max=13)
	private String phoneNo;
	
	@NotNull
	@Size(min=6, max=6)
	@Column(name = "PASSCODE")
	private String passCode;
	
	@Column(name = "POSITIVITY")	
	private int positivity;


	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassCode() {
		return passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	public int getPositivity() {
		return positivity;
	}

	public void setPositivity(int positivity) {
		this.positivity = positivity;
	}

	public Customer() {		
	}
	
	@Override
	public String toString() {
		return custName;
	}
}
