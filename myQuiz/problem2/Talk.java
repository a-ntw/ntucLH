package problem2;

public class Talk {
	private String desc;
	private int mins;
	public Talk(String desc, int mins) {
		super();
		this.desc = desc;
		this.mins = mins;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = mins;
	}
}
