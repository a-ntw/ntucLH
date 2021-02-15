package carDate.veh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehStatusRepo extends JpaRepository<VehStatus, Integer>{
	VehStatus findByName(String name);

}
