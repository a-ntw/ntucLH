package com.ntuc;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private Integer id;
	
	@DateTimeFormat(pattern = "d-m-yyyy")
//	@Temporal(TemporalType.DATE)
	private Date bdate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}


	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String blkDate= formatter.format(bdate);
	 		return  blkDate;
	}
	
	
}
