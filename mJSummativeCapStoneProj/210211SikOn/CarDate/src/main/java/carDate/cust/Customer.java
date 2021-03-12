package carDate.cust;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

import carDate.hire.Hire;
import carDate.pict.Picture;


@Entity // meaning this is linked to a table in the database
@Table(name = "Customer")  // and this is the name of the linked table in the database
public class Customer {
	
	@Id // this is the primary key for this record
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // defines how this id is to be generated....??
	@Column(name="CUSTID")  // The following attribute is linked to this column in the db table
	private long custId;

	@Column(name = "CUSTNAME")  
	@Size (min = 8, max = 45)
	@NotNull
	private String custName;

	@Column(unique=true)
	@Size (min = 9, max = 9, message="Enter a 9-char code")
	@NotNull
	private String nric;

	@Column(name = "EMAIL", unique=true)
	@Email
	@Size (min = 8, max = 30)
	@NotNull
	private String email;

	@Column(name = "PHONENO", unique=true)
	@Size (min = 8, max = 15)
	@NotNull
	private String phoneNo;

	@Column(name = "ADDR1")  
	@Size (min = 2, max = 30)
	@NotNull(message="Should not be null")
	private String addr1;

	@Column(name = "ADDR2")  
	@Size (min = 2, max = 30)
	@NotNull
	private String addr2;

	@Column(name = "CITY")  
	@Size (min = 2, max = 30)
	@NotNull
	private String city;

	@NotNull
	@Column() // when name is not specified, it means db table column name same as attribute variable name
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Column(name = "ISACTIVE")
	private boolean isActive;

	@NotNull
	@Column(name="DATEUPD")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateUpd;

	// need to add an attribute to upload pictures of customer id document/driving license

	// links this.Customer to another for alternative contact
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "CUSTIDLINK", nullable = true)
    private Customer custLinked;

	// links this.Customer to picture of driving license
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "PICTDRLIC", nullable = true)
    private Picture drLic;
    
	// links this.Customer to current hire
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "CURRHIREID", nullable = true)
    private Hire currHire;

	// links this.Customer to Hires
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Hire> hires;

    
	// Constructors
	
	public Customer() {}


	// Getters and Setters
	
	

	public long getCustId() {
		return custId;
	}


	public void setCustId(long custId) {
		this.custId = custId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getNric() {
		return nric;
	}


	public void setNric(String nric) {
		this.nric = nric;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getDateUpd() {
		return dateUpd;
	}


	public void setDateUpd(LocalDate dateUpd) {
		this.dateUpd = dateUpd;
	}


	public Picture getDrLic() {
		return drLic;
	}


	public void setDrLic(Picture drLic) {
		this.drLic = drLic;
	}


	public Customer getCustLinked() {
		return custLinked;
	}


	public void setCustLinked(Customer custLinked) {
		this.custLinked = custLinked;
	}


	public Hire getCurrHire() {
		return currHire;
	}


	public void setCurrHire(Hire currHire) {
		this.currHire = currHire;
	}


	public Set<Hire> getHires() {
		return hires;
	}


	public void setHires(Set<Hire> hires) {
		this.hires = hires;
	}


	//
	
	public void addHire(Hire hire) {
		this.hires.add(hire);
	}

	public void removeHire(Hire hire) {
		this.hires.remove(hire);
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", nric=" + nric + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", addr1=" + addr1 + ", addr2=" + addr2 + ", city=" + city + ", dob=" + dob
				+ ", isActive=" + isActive + ", dateUpd=" + dateUpd + ", hires=" + hires.size()
				+ "]";
	}


	

	
}
