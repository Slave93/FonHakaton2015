package skomarica.examples.jerseyjdbc.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import skomarica.examples.jerseyjdbc.dao.EventDao;
import skomarica.examples.jerseyjdbc.dao.ProfileDao;
import skomarica.examples.jerseyjdbc.model.Event;
import skomarica.examples.jerseyjdbc.model.Profile;
import skomarica.examples.jerseyjdbc.model.helper.AtendieForm;

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

