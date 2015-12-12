package hakaton.mljfs.messenger.resources;

import hakaton.mljfs.messenger.model.ProfileJB;
import hakaton.mljfs.messenger.service.ProfileService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jbprofiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResourceJB {

	private ProfileService profileService = new ProfileService();
	
	
	
	@GET
	public List<ProfileJB> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST
	public ProfileJB addProfile(ProfileJB profile) {
		return profileService.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public ProfileJB getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public ProfileJB updateProfile(@PathParam("profileName") String profileName, ProfileJB profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
	
	
	
}
