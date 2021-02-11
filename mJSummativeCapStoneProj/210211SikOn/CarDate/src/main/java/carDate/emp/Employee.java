package carDate.emp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // defines how this id is to be generated....??
	@Column(name="EMPLOYEEID")  // The following attribute is linked to this column in the db table
	private long empId;

	@Column(name = "EMPNAME", nullable = false, unique = true)
	@Size (min = 4, max = 8)
	@NotNull
	private String empName;

	@NotNull
	private String password;

	@Size (min = 4, max = 45)
	@NotNull
	private String empFullName;

	@Size (min = 8, max = 15)
	@NotNull
	private String phoneNo;

	@Column(name = "EMAIL", unique=true)
	@Email
	@Size (min = 8, max = 30)
	@NotNull
	private String email;

	@Size (min = 5, max = 30)
	@NotNull
	private String jobTitle;

	@Column(name = "ISACTIVE") 
	private boolean isActive;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate userExpiry;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pswdExpiry;


	public Employee() {}

	public Employee(String empName, String password) {
		this.empName = empName;
		this.password = password;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "EMPLOYEES_ROLES",
			joinColumns = @JoinColumn(name = "EMPLOYEEID"),
			inverseJoinColumns = @JoinColumn(name = "ROLEID")
			)
	
	private Set<Role> roles = new HashSet<>(); 


	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	public String getEmpFullName() {
		return empFullName;
	}

	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getUserExpiry() {
		return userExpiry;
	}

	public void setUserExpiry(LocalDate userExpiry) {
		this.userExpiry = userExpiry;
	}

	public LocalDate getPswdExpiry() {
		return pswdExpiry;
	}

	public void setPswdExpiry(LocalDate pswdExpiry) {
		this.pswdExpiry = pswdExpiry;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public void removeRole(Role role) {
		this.roles.remove(role);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", jobTitle=" + jobTitle + ", isActive=" + isActive + ", userExpiry="
				+ userExpiry + ", pswdExpiry=" + pswdExpiry + ", roles=" + roles + "]";
	}

	
	
}
