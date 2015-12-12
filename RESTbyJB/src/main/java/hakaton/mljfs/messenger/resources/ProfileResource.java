package hakaton.mljfs.messenger.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import hakaton.mljfs.messenger.dao.BuildingDao;
import hakaton.mljfs.messenger.dao.ProfileDao;
import hakaton.mljfs.messenger.dao.TypeDao;
import hakaton.mljfs.messenger.model.Building;
import hakaton.mljfs.messenger.model.Message;
import hakaton.mljfs.messenger.model.Profile;
import hakaton.mljfs.messenger.model.Type;
import hakaton.mljfs.messenger.model.registration.RegistrationForm;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class ProfileResource {

	@GET
	public List<Profile> getEmailProfile(@QueryParam("email") String email) {		
		List<Profile> profiles = new ArrayList<>();
		if (email != null){
			Profile prof = ProfileDao.getProfileByEmail(email);
			if(prof.getId()==-1){
				return null;
			}
			profiles.add(prof);
			return profiles;
		}		
		return ProfileDao.getAllProfiles();
	}
	@POST
	public Profile addProfile(RegistrationForm regForm) {
		System.out.println("trying to add profile");
		String city = regForm.getCity();
		String state = regForm.getState();
		String phone = regForm.getPhone();
		String email = regForm.getEmail();
		String facultyName = regForm.getFacultyName();
		Building faculty = BuildingDao.getBuilding(facultyName);		
		String hallName = regForm.getHallName();
		Building hall = BuildingDao.getBuilding(hallName);
		String name = regForm.getName();
		String password = regForm.getPassword();
		Profile profile = new Profile(-1, email, password, phone, city, state, faculty, hall, name);
		boolean sucess = ProfileDao.addProfile(profile);
		if(!sucess){
			Response res =  Response.status(Status.BAD_REQUEST).entity(profile).build();
			throw new  WebApplicationException(res);
		}
		return profile;
	}
}
