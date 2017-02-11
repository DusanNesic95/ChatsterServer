package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Messages;
import net.sytes.codeline.entities.User;

public interface MessagesDao {

	public boolean sendMessage(Messages message);
	public List<Messages> getMessages(User from, User to);
	
}
