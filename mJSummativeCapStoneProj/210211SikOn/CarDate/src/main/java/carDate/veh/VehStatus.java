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

	public Integer getVehSttsId() {
		return vehSttsId;
	}

	public void setVehSttsId(Integer vehSttsId) {
		this.vehSttsId = vehSttsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public VehStatus() {
		super();
	}

	@Override
	public String toString() {
		return "VehStatus [vehSttsId=" + vehSttsId + ", name=" + name + "]";
	}
	
	
	
}
