package springauth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
//	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//			+ " OR p.brand LIKE %?1%"
//			+ " OR p.madein LIKE %?1%"	)
//	public List<Product> findAll(String keyword);
	
	@Query("SELECT p FROM Product p WHERE "
			+ " CONCAT(p.id, p.name, p.madein, p.brand, p.price)" 
			+  " LIKE %?1%" )
	public Page<Product> findAll(String keyword,Pageable pageable);
	
}
