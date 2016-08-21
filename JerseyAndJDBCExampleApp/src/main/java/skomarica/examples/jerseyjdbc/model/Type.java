package skomarica.examples.jerseyjdbc.model;

public class Type {
	
	private int id;
	private String nameeng;
	private String namesr;
	
	public Type(){
		
	}
	
	public Type(int id, String nameeng, String namesr) {		
		this.id = id;
		this.nameeng = nameeng;
		this.namesr = namesr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameeng() {
		return nameeng;
	}

	public void setNameeng(String nameeng) {
		this.nameeng = nameeng;
	}

	public String getNamesr() {
		return namesr;
	}

	public void setNamesr(String namesr) {
		this.namesr = namesr;
	}
	
	
	
	
}
