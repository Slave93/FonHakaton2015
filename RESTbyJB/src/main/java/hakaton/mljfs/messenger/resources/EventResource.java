package hakaton.mljfs.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import hakaton.mljfs.messenger.dao.EventDao;
import hakaton.mljfs.messenger.dao.FeatureDao;
import hakaton.mljfs.messenger.dao.ProfileDao;
import hakaton.mljfs.messenger.model.Event;
import hakaton.mljfs.messenger.model.Feature;
import hakaton.mljfs.messenger.model.Profile;
import hakaton.mljfs.messenger.model.helper.AtendieForm;
import hakaton.mljfs.messenger.model.registration.RegistrationForm;

@Path("/events")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class EventResource {	
	
	@GET	
	public List<Event> getEvents() {		
		return EventDao.getAllEvents();
	}	
	
	@POST
	public void addEventAtendie(AtendieForm af){
		Profile profile = ProfileDao.getProfileByEmail(af.getEmail());
		int profileID = profile.getId();
		if(profileID>0){
			EventDao.addAtendie(profileID,af.getEvent());
		}
	}

}

