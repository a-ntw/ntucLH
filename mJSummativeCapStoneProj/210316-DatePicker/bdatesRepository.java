package com.ntuc;

import java.time.LocalDate;
//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bdatesRepository extends JpaRepository<blockdates, LocalDate> {
	 
}
