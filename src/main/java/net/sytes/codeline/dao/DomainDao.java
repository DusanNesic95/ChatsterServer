package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Domain;

public interface DomainDao {

	public boolean addDomain(Domain domain);
	public boolean deleteDomain(int id);
	public List<Domain> getAllDomains();
	
}
