	package carDate.pict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PICTURE")
public class Picture {
	@Id // this is the primary key for this record
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // defines how this id is to be generated....??
	@Column(name="PICTID")  // The following attribute is linked to this column in the db table
	private long pictId;
  
	private String name;

	private String type;

	@Lob
	private byte[] data;

	public Picture() {
	}

	public Picture(String name, String type, byte[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public long getPictId() {
		return pictId;
 	}

	public String getName() {
		return name;
 	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
 	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Picture [pictId=" + pictId + ", name=" + name + ", type=" + type + "]";
	}

	
	
}
