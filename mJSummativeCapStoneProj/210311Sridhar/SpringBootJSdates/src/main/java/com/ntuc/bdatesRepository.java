package com.ntuc;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface bdatesRepository extends JpaRepository<blockdates, Integer> {
	

	@Query(value = "select BDATE from BOOKED_DATES", nativeQuery = true)
    Date[] showDates();
	 
}
