package com.ntuc;

import java.time.LocalDate;
//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface bdatesRepository extends JpaRepository<Blockdate, LocalDate> {
//	@Query(value = "select BDATE from BOOKED_DATES", nativeQuery = true)
//    LocalDate[] showDates();
}
