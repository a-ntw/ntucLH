package com.cp5;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c WHERE CONCAT(c.custId, ' ', c.custName, ' ', c.dob, ' ', c.email, ' ', c.isActive, ' ', c.phoneNo) LIKE %?1%")
//	@Query("SELECT c FROM Customer c WHERE CONCAT(c.custName, ' ', c.custId, ' ', c.email, ' ', c.phoneNo) LIKE %?1%")
	public Page<Customer> search(String keyword, Pageable pageable);
//	public List<Customer> search(String keyword);
}
