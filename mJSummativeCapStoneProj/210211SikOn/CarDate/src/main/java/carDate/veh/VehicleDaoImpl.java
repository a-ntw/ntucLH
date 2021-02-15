package carDate.veh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VehicleDaoImpl implements VehicleDao{

	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Override
	
	public List<Vehicle> getAllVehicles() {
		return vehicleRepo.findAll();
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
		
	}

	@Override
	public Vehicle getVehicleById(long vehId) {
		Optional <Vehicle> optional = vehicleRepo.findById(vehId);
		Vehicle vehicle = null;
		if (optional.isPresent())
			vehicle = optional.get();
		else
			throw new RuntimeException("Vehicle not found for id=" + vehId);
		return vehicle;
	}

	@Override
	public void deleteVehicleById(long vehId) {
		vehicleRepo.deleteById(vehId);
		
	}

	@Override
	public Page<Vehicle> vehPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); // Note pageNo starts from 0, not 1, hence the -1.
		return vehicleRepo.findAll(pageable);
	}


}
