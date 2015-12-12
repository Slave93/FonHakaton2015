package hakaton.mljfs.messenger.service;

import hakaton.mljfs.messenger.database.DatabaseClass;
import hakaton.mljfs.messenger.model.ProfileJB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

	private Map<String, ProfileJB> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("koushik", new ProfileJB(1L, "koushik", "Koushik", "Kothagal"));
	}
	
	public List<ProfileJB> getAllProfiles() {
		return new ArrayList<ProfileJB>(profiles.values()); 
	}
	
	public ProfileJB getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public ProfileJB addProfile(ProfileJB profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public ProfileJB updateProfile(ProfileJB profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public ProfileJB removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
