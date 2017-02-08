package net.sytes.codeline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Domain;
import net.sytes.codeline.entities.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl() {}
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public boolean addUser(User user) {
		User currentUser = currentUser(user);
		
		if (currentUser == null) {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		return false;
	}

	private User currentUser(User user) {
		User currentUser = (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", user.getUsername()))
				.uniqueResult();
		return currentUser;
	}

	@Override
	@Transactional
	public boolean editUser(User user) {
		User currentUser = currentUser(user);
		
		if (currentUser == null) {
			return false;
		}
		
		currentUser.setPassword(user.getPassword());
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setAddress(user.getAddress());
		currentUser.setPhoneNumher(user.getPhoneNumher());
		currentUser.setPhoto(user.getPhoto());
		sessionFactory.getCurrentSession().update(currentUser);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUser(int id) {
		User currentUser = getUserById(id);
		
		if (currentUser == null) {
			return false;
		}
		sessionFactory.getCurrentSession().delete(currentUser);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getUsersByDomain(Domain domain) {
		return sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("domainId", domain))
				.list();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		User currentUser = (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("userId", id))
				.uniqueResult();
		return currentUser;
	}
	
	@Override
	@Transactional
	public User login(User user) {
		User currentUser = currentUser(user);
		
		if (currentUser == null) {
			User notExisting = new User();
			notExisting.setUsername("null");
			return notExisting;
		}
		if (currentUser.getPassword().equals(user.getPassword())) {
			return currentUser;
		}
		User wrongPassword = new User();
		wrongPassword.setUsername("wrong");
		return wrongPassword;
	}
	
	@Override
	@Transactional
	public List<User> getContactsForDomain(User user) {
		String domainParams[] = user.getUsername().split("@");
		String domain = domainParams[1];
		
		List<User> allUsers = getAllUsers();
		List<User> contacts = new ArrayList<>();
		
		for (User usr : allUsers) {
			if (usr.getDomainId().getDomainCode().equals(domain) 
					&& !usr.getUsername().equals(user.getUsername())) {
				contacts.add(usr);
			}
		}
		
		return contacts;
	}

}
