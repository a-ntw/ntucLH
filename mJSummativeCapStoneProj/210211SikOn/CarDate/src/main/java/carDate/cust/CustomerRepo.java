package carDate.cust;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByCustName(String custName);
	

	// note that the table and column names used below should follow pojo, not database.
    @Query("SELECT c FROM Customer c WHERE CONCAT(c.custId, ' ', c.addr1, ' ', c.addr2, ' ', c.city, ' ', c.custName, ' ', c.email, ' ', c.nric, ' ', c.phoneNo) LIKE %?1%")
	public Page<Customer> search(String keyword, Pageable pageable);
	
}
