package com.kapitanov.messenger.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;

import com.kapitanov.messenger.database.Database;
import com.kapitanov.messenger.model.Message;

public class MessageService {
	
	private static Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "koushik"));
		messages.put(2L, new Message(2, "Hello Jersey", "koushik"));
	}
	
	public List<Message> getAllMessagesPerYear(int year) {
		List<Message> result = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				result.add(message);
			}
		}
		return result;
	}
	
	public List<Message> getMessagesPaginated(int start, int size) {
		List<Message> result = new ArrayList<>(messages.values());
		return result.subList(start, start + size);
	}
	
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
	
	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() < 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

}
