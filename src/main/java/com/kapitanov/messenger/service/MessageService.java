package com.kapitanov.messenger.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.kapitanov.messenger.database.Database;
import com.kapitanov.messenger.model.Message;

public class MessageService {
	
	private static Map<Long, Message> messages = Database.getMessages();
	
	public Message addMessag(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public List<Message> getAllMessages() {
		List<Message> result = new ArrayList<>();
		for (Long key : messages.keySet()) {
			result.add(messages.get(key));
		}
		return result;
	}
	
	public Message getMessage(Long id) {
		Message message = messages.get(id);
		return message;
	}
	
	public void removeMessage(Long id) {
		messages.remove(id);
	}
	
	public Message updateMessage(Long id, Message message) {
		if (message.getId() < 0) {
			return null;
		}
		messages.put(id, message);
		return message;
	}

}
