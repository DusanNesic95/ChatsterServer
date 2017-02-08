package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Domain;
import net.sytes.codeline.entities.User;

public interface UserDao {

	public boolean addUser(User user);
	public boolean editUser(User user);
	public boolean deleteUser(int id);
	public List<User> getAllUsers();
	public List<User> getUsersByDomain(Domain domain);
	public User getUserById(int id);
	public User login(User user);
	public List<User> getContactsForDomain(User user);
	
}
