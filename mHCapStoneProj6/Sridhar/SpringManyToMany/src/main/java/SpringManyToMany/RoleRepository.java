package SpringManyToMany;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Roles, Long>{
	
	
	@Query("select count(u), r.name from Users u inner join u.roles r group by r.name")
	public List<?> findR();


		
}
