package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.DomainDao;
import net.sytes.codeline.entities.Domain;

@RestController
public class DomainController {

	@Autowired
	private DomainDao domainDao;
	
	@RequestMapping(value="/adddomain", method=RequestMethod.POST)
	public boolean addDomain(@RequestBody Domain domain) {
		return domainDao.addDomain(domain);
	}
	
	@RequestMapping(value="/deletedomain", method=RequestMethod.POST)
	public boolean deleteDomain(@RequestBody Domain domain) {
		return domainDao.deleteDomain(domain.getDomainId());
	}
	
	@RequestMapping(value="/getalldomains", method=RequestMethod.POST)
	public List<Domain> getAllDomains() {
		return domainDao.getAllDomains();
	}
	
}
