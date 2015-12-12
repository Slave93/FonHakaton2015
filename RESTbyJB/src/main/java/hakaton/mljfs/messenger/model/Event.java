package hakaton.mljfs.messenger.model;

import java.util.Date;
import java.util.List;

public class Event {
	private int id;
	private Profile admin;
	private List<Profile> atendies;
	private String type;
	private String place;
	private Date time;
	private int minatend;
	private int maxatend;
	private String description;
	private String name;
	
	
	public Event(){
		
	}

	public Event(int id, Profile admin, List<Profile> atendies, String type, String place, Date time, int minatend,
			int maxatend, String description, String name) {		
		this.id = id;
		this.admin = admin;
		this.atendies = atendies;
		this.type = type;
		this.place = place;
		this.time = time;
		this.minatend = minatend;
		this.maxatend = maxatend;
		this.description = description;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getAdmin() {
		return admin;
	}

	public void setAdmin(Profile admin) {
		this.admin = admin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getMinatend() {
		return minatend;
	}

	public void setMinatend(int minatend) {
		this.minatend = minatend;
	}

	public int getMaxatend() {
		return maxatend;
	}

	public void setMaxatend(int maxatend) {
		this.maxatend = maxatend;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Profile> getAtendies() {
		return atendies;
	}

	public void setAtendies(List<Profile> atendies) {
		this.atendies = atendies;
	}
	
	
	
	
}
