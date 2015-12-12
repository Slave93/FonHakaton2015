package hakaton.mljfs.messenger.database;

import hakaton.mljfs.messenger.model.Message;
import hakaton.mljfs.messenger.model.ProfileJB;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, ProfileJB> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, ProfileJB> getProfiles() {
		return profiles;
	}

	
	
	
}
