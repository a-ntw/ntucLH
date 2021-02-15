package carDate.hire;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HireDaoImpl implements HireDao{

	@Autowired
	private HireRepo hireRepo;
	
	@Override
	
	public List<Hire> getAllHires() {
		return hireRepo.findAll();
	}

	@Override
	public void saveHire(Hire hire) {
		hireRepo.save(hire);
		
	}

	@Override
	public Hire getHireById(long hireId) {
		Optional <Hire> optional = hireRepo.findById(hireId);
		Hire hire = null;
		if (optional.isPresent())
			hire = optional.get();
		else
			throw new RuntimeException("Hire not found for id=" + hireId);
		return hire;
	}

	@Override
	public void deleteHireById(long hireId) {
		hireRepo.deleteById(hireId);
		
	}

	@Override
	public Page<Hire> hirePaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); // Note pageNo starts from 0, not 1, hence the -1.
		return hireRepo.findAll(pageable);
	}

}
