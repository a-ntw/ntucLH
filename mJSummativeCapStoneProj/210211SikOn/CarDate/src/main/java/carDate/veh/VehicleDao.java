package carDate.veh;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface VehicleDao {

	public List<Vehicle> getAllVehicles();
	public void saveVehicle(Vehicle vehicle);
	public Vehicle getVehicleById(long vehId);
	public void deleteVehicleById(long vehId);
	public Page<Vehicle> vehPaginated(int pageNo, int pageSize, String sortField, String sortDirection); 

}

