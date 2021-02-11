package carDate.veh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import carDate.cust.Customer;
import carDate.hire.Hire;

@Entity // meaning this is linked to a table in the database
public class Vehicle {


	
	@Id // this is the primary key for this record
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // defines how this id is to be generated....??
	@Column(name="VEHID")  // The following attribute is linked to this column in the db table
	private long VehId;

	@Size (min = 8, max = 25)
	@NotNull
	private String vehModel;

	@Size (min = 8, max = 25)
	@NotNull
	private String vehBrand;

	@Column(unique=true)
	@Size (min = 3, max = 8)
	@NotNull
	private String vehLicPlate;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "CURHIREID", nullable = true)
    private Hire currHire;

	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "VEHSTTSID", nullable = false)
    private VehStatus vehStatus;

	
}
