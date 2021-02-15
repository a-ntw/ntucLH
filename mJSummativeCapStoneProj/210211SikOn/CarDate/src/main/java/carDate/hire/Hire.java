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
import carDate.emp.Employee;
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
	private Employee empFulfill;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "EMPIDEND", nullable = true)
	private Employee empReturn;

    @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dtsStart;

    @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dtsEnd;
	
    @NotNull
	private double dailyRate;  // daily rate of this Vehicle as at time of hire,
    // rate will be used through out this Hire.
	
    @NotNull
	private double deposit;
	
    @NotNull
	private double HireFee;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dtsEndActual;
	
	private double hireFeeActual;
	

	// Constructor	
	public Hire() {
		super();
	}

	// getters and setters

	public long getHireId() {
		return hireId;
	}


	public void setHireId(long hireId) {
		this.hireId = hireId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Employee getEmpFulfill() {
		return empFulfill;
	}


	public void setEmpFulfill(Employee empFulfill) {
		this.empFulfill = empFulfill;
	}


	public Employee getEmpReturn() {
		return empReturn;
	}


	public void setEmpReturn(Employee empReturn) {
		this.empReturn = empReturn;
	}


	public LocalDateTime getDtsStart() {
		return dtsStart;
	}

	public void setDtsStart(LocalDateTime dtsStart) {
		this.dtsStart = dtsStart;
	}


	public LocalDateTime getDtsEnd() {
		return dtsEnd;
	}


	public void setDtsEnd(LocalDateTime dtsEnd) {
		this.dtsEnd = dtsEnd;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public double getDeposit() {
		return deposit;
	}


	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}


	public double getHireFee() {
		return HireFee;
	}


	public void setHireFee(double hireFee) {
		HireFee = hireFee;
	}


	public LocalDateTime getDtsEndActual() {
		return dtsEndActual;
	}


	public void setDtsEndActual(LocalDateTime dtsEndActual) {
		this.dtsEndActual = dtsEndActual;
	}


	public double getHireFeeActual() {
		return hireFeeActual;
	}


	public void setHireFeeActual(double hireFeeActual) {
		this.hireFeeActual = hireFeeActual;
	}

	@Override
	public String toString() {
		return "Hire [hireId=" + hireId + ", dtsStart=" + dtsStart + ", dtsEnd=" + dtsEnd
				+ ", deposit=" + deposit + ", HireFee=" + HireFee + ", dtsEndActual=" + dtsEndActual
				+ ", hireFeeActual=" + hireFeeActual + "]";
	}
	

	
}



