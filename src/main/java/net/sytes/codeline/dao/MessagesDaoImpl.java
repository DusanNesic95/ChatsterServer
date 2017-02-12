package net.sytes.codeline.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Messages;
import net.sytes.codeline.entities.User;

@Repository
public class MessagesDaoImpl implements MessagesDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MessagesDaoImpl() {}
	
	public MessagesDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean sendMessage(Messages message) {
		sessionFactory.getCurrentSession().save(message);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Messages> getMessages(User from, User to) {
		List<Messages> allMessages = new ArrayList<>();
		List<Messages> myMessages = sessionFactory.getCurrentSession()
				.createCriteria(Messages.class)
				.add(Restrictions.eq("fromUserId", from))
				.add(Restrictions.eq("toUserId", to))
				.list();
		List<Messages> responseMessages = sessionFactory.getCurrentSession()
				.createCriteria(Messages.class)
				.add(Restrictions.eq("fromUserId", to))
				.add(Restrictions.eq("toUserId", from))
				.list();

		allMessages.addAll(myMessages);
		allMessages.addAll(responseMessages);
		
		return allMessages;
	}

}
