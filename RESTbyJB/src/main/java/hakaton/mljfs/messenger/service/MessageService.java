package hakaton.mljfs.messenger.service;

import hakaton.mljfs.messenger.database.DatabaseClass;
import hakaton.mljfs.messenger.model.Comment;
import hakaton.mljfs.messenger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		Map<Long,Comment> hardCodeComments = new HashMap();
		Comment c1 = new Comment(1,"Hardcode comment 1","Me");
		Comment c2 = new Comment(1,"Hardcode comment 2","Also me");
		hardCodeComments.put(1l, c1);
		hardCodeComments.put(2l, c2);
		Message message1 = new Message(1, "Hello World", "koushik");
		message1.setComments(hardCodeComments);
		messages.put(1L, message1);
		messages.put(2L, new Message(2, "Hello Jersey", "koushik"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	

	
	
	
}
