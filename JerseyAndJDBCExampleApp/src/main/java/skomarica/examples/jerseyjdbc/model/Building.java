package skomarica.examples.jerseyjdbc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Building {
	
	private int id;
    private String namesr;
    private int yearbuild;
    private String description;
    
   
    private String features;    
    private List<Feature> featurelist;
    private String brojoObrokaUMenzi;    
    private String brojLjudiUMenzi;
    
    private String webpage;
    private String longitude;
    private String latitude;
    private String polygon;
    private Organisation organisation;
    private Type type;
    private Site site;
    
    public Building() {
    	
    }

	public Building(int id, String namesr, int yearbuild, String description, String features,
			List<Feature> featurelist, String brojoObrokaUMenzi, String brojLjudiUMenzi, String webpage,
			String longitude, String latitude, String polygon, Organisation organisation, Type type, Site site) {		
		this.id = id;
		this.namesr = namesr;
		this.yearbuild = yearbuild;
		this.description = description;
		this.features = features;
		this.featurelist = featurelist;
		this.brojoObrokaUMenzi = brojoObrokaUMenzi;
		this.brojLjudiUMenzi = brojLjudiUMenzi;
		this.webpage = webpage;
		this.longitude = longitude;
		this.latitude = latitude;
		this.polygon = polygon;
		this.organisation = organisation;
		this.type = type;
		this.site = site;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamesr() {
		return namesr;
	}

	public void setNamesr(String namesr) {
		this.namesr = namesr;
	}

	public int getYearbuild() {
		return yearbuild;
	}

	public void setYearbuild(int yearbuild) {
		this.yearbuild = yearbuild;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public List<Feature> getFeaturelist() {
		return featurelist;
	}

	public void setFeaturelist(List<Feature> featurelist) {
		this.featurelist = featurelist;
	}

	public String getBrojoObrokaUMenzi() {
		return brojoObrokaUMenzi;
	}

	public void setBrojoObrokaUMenzi(String brojoObrokaUMenzi) {
		this.brojoObrokaUMenzi = brojoObrokaUMenzi;
	}

	public String getBrojLjudiUMenzi() {
		return brojLjudiUMenzi;
	}

	public void setBrojLjudiUMenzi(String brojLjudiUMenzi) {
		this.brojLjudiUMenzi = brojLjudiUMenzi;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPolygon() {
		return polygon;
	}

	public void setPolygon(String polygon) {
		this.polygon = polygon;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
    
    
	
	
	
	
}
