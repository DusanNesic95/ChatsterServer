package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.sytes.codeline.dao.MessagesDao;
import net.sytes.codeline.entities.Messages;
import net.sytes.codeline.entities.UsersReceiver;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

	@Autowired
	private MessagesDao messagesDao;
	
	@CrossOrigin
	@RequestMapping(value="/sendmessage", method=RequestMethod.POST)
	public boolean sendMessage(@RequestBody Messages message) {
		return messagesDao.sendMessage(message);
	}
	
	@CrossOrigin
	@RequestMapping(value="/getmessages", method=RequestMethod.POST)
	public List<Messages> getMessages(@RequestBody UsersReceiver receiver) {
		return messagesDao.getMessages(receiver.getFrom(), receiver.getTo());
	}
}
