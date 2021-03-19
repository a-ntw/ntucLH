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
public class Blockdate {
	
	@Id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate bdate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate edate;
	
	
	public Blockdate() {
		super();
	}

	public LocalDate getBdate() {
		return bdate;
	}

	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}

	public LocalDate getEdate() {
		return edate;
	}

	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}

	@Override
	public String toString() {
		return "Blockdate [bdate=" + bdate + ", edate=" + edate + "]";
	}

}

