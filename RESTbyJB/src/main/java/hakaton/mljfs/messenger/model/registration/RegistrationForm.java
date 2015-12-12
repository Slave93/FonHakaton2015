package hakaton.mljfs.messenger.model.registration;

import javax.xml.bind.annotation.XmlRootElement;

import hakaton.mljfs.messenger.model.Building;

@XmlRootElement
public class RegistrationForm {
	
	private String email;
	private String password;
	private String phone;
	private String city;
	private String state;
	private String facultyName;
	private String hallName;
	private String name;
	
	public RegistrationForm(){
		
	}

	public RegistrationForm(String email, String password, String phone, String city, String state, String facultyName,
			String hallName, String name) {		
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.facultyName = facultyName;
		this.hallName = hallName;
		this.name = name;
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

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
	
	
	