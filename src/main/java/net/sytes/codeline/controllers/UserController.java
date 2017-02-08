package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.UserDao;
import net.sytes.codeline.entities.Domain;
import net.sytes.codeline.entities.User;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public boolean addUser(@RequestBody User user) {
		return userDao.addUser(user);
	}
	
	@RequestMapping(value="/edituser", method=RequestMethod.POST)
	public boolean editUser(@RequestBody User user) {
		return userDao.editUser(user);
	}
	
	@RequestMapping(value="/deleteuser", method=RequestMethod.POST)
	public boolean deleteUser(@RequestBody User user) {
		return userDao.deleteUser(user.getUserId());
	}
	
	@RequestMapping(value="/getallusers", method=RequestMethod.POST)
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@RequestMapping(value="/getusersbydomain", method=RequestMethod.POST)
	public List<User> getUsersByDomain(@RequestBody Domain domain) {
		return userDao.getUsersByDomain(domain);
	}
	
	@RequestMapping(value="/getuserbyid", method=RequestMethod.POST)
	public User getUserById(@RequestBody User user) {
		return userDao.getUserById(user.getUserId());
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User login(@RequestBody User user) {
		return userDao.login(user);
	}
	
	@RequestMapping(value="/getcontactsfordomain", method=RequestMethod.POST)
	public List<User> getContactsForDomain(@RequestBody User user) {
		return userDao.getContactsForDomain(user);
	}
	
}
