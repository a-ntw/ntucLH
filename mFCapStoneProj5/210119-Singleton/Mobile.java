package ntuc;

import org.springframework.stereotype.Component;

@Component
//@Component("simon")
public class Mobile {
	
	private int id;
	private String name;
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
		return "Mobile [id=" + id + ", name=" + name + "]";
	}
	
	public void add() {
		System.out.println("Adding a mobile");
	}

}
