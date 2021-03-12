package carDate.veh;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import carDate.hire.Hire;
import carDate.pict.Picture;

@Entity // meaning this is linked to a table in the database
public class Vehicle {


	
	@Id // this is the primary key for this record
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // defines how this id is to be generated....??
	@Column(name="VEHID")  // The following attribute is linked to this column in the db table
	private long vehId;

	@Size (min = 3, max = 15)
	@NotNull
	private String vehBrand;

	@Size (min = 1, max = 20)
	@NotNull
	private String vehModel;

	@Column(unique=true)
	@Size (min = 3, max = 8)
	@NotNull
	private String vehLicPlate;

	private int engCap;
	
	private int bhp;
	
	private int topSpeed;
	
	@Min(value=50)
	@Max(value=999)
	@NotNull
	private float dailyRate;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    private Picture picture;

	// links this.Vehicle to Pictures
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    private Hire currHire;

	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "VEHSTTSID", nullable = false)
    private VehStatus vehStatus;


	// links this.Vehicle to Hires
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Hire> hires;

    
    
	/**
	 * 
	 */
	public Vehicle() {
		super();
	}


	public long getVehId() {
		return vehId;
	}


	public void setVehId(long vehId) {
		this.vehId = vehId;
	}


	public String getVehModel() {
		return vehModel;
	}


	public void setVehModel(String vehModel) {
		this.vehModel = vehModel;
	}


	public String getVehBrand() {
		return vehBrand;
	}


	public void setVehBrand(String vehBrand) {
		this.vehBrand = vehBrand;
	}


	public String getVehLicPlate() {
		return vehLicPlate;
	}


	public void setVehLicPlate(String vehLicPlate) {
		this.vehLicPlate = vehLicPlate;
	}


	public int getEngCap() {
		return engCap;
	}




	public void setEngCap(int engCap) {
		this.engCap = engCap;
	}




	public int getBhp() {
		return bhp;
	}




	public void setBhp(int bhp) {
		this.bhp = bhp;
	}




	public int getTopSpeed() {
		return topSpeed;
	}




	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}




	public float getDailyRate() {
		return dailyRate;
	}


	public void setDailyRate(float dailyRate) {
		this.dailyRate = dailyRate;
	}




	public Picture getPicture() {
		return picture;
	}




	public void setPicture(Picture picture) {
		this.picture = picture;
	}




	public Set<Picture> getPictures() {
		return pictures;
	}




	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}




	public Hire getCurrHire() {
		return currHire;
	}


	public void setCurrHire(Hire currHire) {
		this.currHire = currHire;
	}


	public VehStatus getVehStatus() {
		return vehStatus;
	}


	public void setVehStatus(VehStatus vehStatus) {
		this.vehStatus = vehStatus;
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


	public void addPicture(Picture picture) {
		this.pictures.add(picture);
	}

	public void removePicture(Picture picture) {
		this.pictures.remove(picture);
	}

	@Override
	public String toString() {
		return "Vehicle [vehId=" + vehId + ", vehModel=" + vehModel + ", vehBrand=" + vehBrand + ", vehLicPlate="
				+ vehLicPlate + ", vehStatus=" + vehStatus + "]";
	}

    
	
}
