package pl.pitek.model;

public class KontaktModel {

	private String first;
	private String last;
	private String email;
	
	public KontaktModel() {
		super();
	}
	public KontaktModel(String first, String last, String email) {
		super();
		this.first = first;
		this.last = last;
		this.email = email;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
