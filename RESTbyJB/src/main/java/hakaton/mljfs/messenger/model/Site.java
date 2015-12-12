package hakaton.mljfs.messenger.model;

import java.util.Date;

public class Site {
	private String id;
	private String nameeng;
	private String polygon;	

	public Site() {
    	
    }

	public Site(String id1, String nameeng1, String polygon1) {
    	this.id = id1;
    	this.nameeng = nameeng1;
    	this.polygon = polygon1;    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameeng() {
		return nameeng;
	}

	public void setNameeng(String nameeng) {
		this.nameeng = nameeng;
	}

	public String getPolygon() {
		return polygon;
	}

	public void setPolygon(String polygon) {
		this.polygon = polygon;
	}

	
}
