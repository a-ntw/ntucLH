package ntuc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Product {
	
	public Product() {
		System.out.println("Object Created");
	}
	
	private int id;
	private String name;
	
	@Autowired // byType
//	@Qualifier("simon")
	private Mobile mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
	public void Present() {
		System.out.println("Presented");
		mobile.add();
	}

}
