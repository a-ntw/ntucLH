package com.ntuc;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="booked_dates")
@Component
public class blockdates {
	@Id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate bdate;
	

	public LocalDate getBate() {
		return bdate;
	}

	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}
}
/*
 import java.util.Date;
 public class blockdates {
	@Id
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date bdate;
	

	public Date getBate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
}
 * */
