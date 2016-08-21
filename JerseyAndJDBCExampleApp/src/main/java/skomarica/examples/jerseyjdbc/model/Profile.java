package skomarica.examples.jerseyjdbc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private int id;
	private String email;
	private String password;
	private String phone;
	private String city;
	private String state;
	private Building faculty;
	private Building hall;
	private String name;
	
	public Profile(){
		
	}

	public Profile(int id, String email, String password, String phone, String city, String state, Building faculty,
			Building hall,String name) {		
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.faculty = faculty;
		this.hall = hall;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Building getFaculty() {
		return faculty;
	}

	public void setFaculty(Building faculty) {
		this.faculty = faculty;
	}

	public Building getHall() {
		return hall;
	}

	public void setHall(Building hall) {
		this.hall = hall;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}
