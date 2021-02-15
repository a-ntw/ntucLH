package carDate.hire;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface HireDao {

	public List<Hire> getAllHires();
	public void saveHire(Hire hireloyee);
	public Hire getHireById(long hireId);
	public void deleteHireById(long hireId);
	public Page<Hire> hirePaginated(int pageNo, int pageSize, String sortField, String sortDirection); 

}
