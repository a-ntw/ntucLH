package com.cp5;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "myfile")
public class Myfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fid")
	private long fid;
	
	@Column(name = "fname")
	@NotNull
	@Size(min = 3, max = 30)
	private String fname;
	
	@Column(name = "fkind")
	@NotNull
	@Size(min = 3, max = 10)
	private String fkind;
	
	@Column(name = "fdcreate")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fdcreate;
	
	@Column(name = "ffolder")
	@NotNull
	@Size(min = 3, max = 30)
	private String ffolder;

	@Column(name = "fsize")
	@NotNull
	private double fsize;
	
	@Column(name = "isActive")
	private boolean isActive;	
	

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFkind() {
		return fkind;
	}

	public void setFkind(String fkind) {
		this.fkind = fkind;
	}

	public LocalDate getFdcreate() {
		return fdcreate;
	}

	public void setFdcreate(LocalDate fdcreate) {
		this.fdcreate = fdcreate;
	}

	public String getFfolder() {
		return ffolder;
	}

	public void setFfolder(String ffolder) {
		this.ffolder = ffolder;
	}

	public double getFsize() {
		return fsize;
	}

	public void setFsize(double fsize) {
		this.fsize = fsize;
	}

	public boolean getIsActive() {  				/* edit for SQL */
		return isActive;
	}

	public void setIsActive(boolean isActive) { 	/* edit for SQL */
		this.isActive = isActive;
	}

}
