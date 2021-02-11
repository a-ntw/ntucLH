package carDate.veh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class VehStatus {

	@Id
	@Column(name = "VEHSTTSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vehSttsId;
	
	@Column(length = 15, nullable = false, unique = true)
	private String name;
	
	
}
