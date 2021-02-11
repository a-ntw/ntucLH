package carDate.hire;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;


import carDate.cust.Customer;
import carDate.veh.Vehicle;

@Entity // meaning this is linked to a table in the database
public class Hire {

	@Id // this is the primary key for this record
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // defines how this id is to be generated....??
	@Column(name="HIREID")  // The following attribute is linked to this column in the db table
	private long hireId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CUSTID", nullable = false)
	private Customer customer;
	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "VEHID", nullable = false)
	private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "EMPIDBEG", nullable = false)
	private Vehicle empFulfill;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "EMPIDEND", nullable = false)
	private Vehicle empReturn;

    private LocalDateTime DtsStart;

	private LocalDateTime DtsEnd;
	
	private double deposit;
	
	private double HireFee;

	private LocalDateTime DtsEndActual;
	
	private double HireFeeActual;

}



