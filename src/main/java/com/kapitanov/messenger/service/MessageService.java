package com.kapitanov.messenger.service;

import java.util.List;
import java.util.ArrayList;
import com.kapitanov.messenger.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages() {
		Message m1 = new Message(1L,"Piss off", "Baba");
		Message m2 = new Message(2L,"Fuck", "Diado");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}

}
