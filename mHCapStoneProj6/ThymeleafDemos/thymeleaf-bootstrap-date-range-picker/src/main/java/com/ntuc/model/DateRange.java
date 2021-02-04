package com.ntuc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class DateRange {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public DateRange() {
		super();
	}

    
    
}
