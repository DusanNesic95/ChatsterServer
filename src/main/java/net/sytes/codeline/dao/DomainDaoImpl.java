package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Domain;

@Repository
public class DomainDaoImpl implements DomainDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public DomainDaoImpl() {}
	
	public DomainDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public boolean addDomain(Domain domain) {
		Domain currentDomain = currentDomain(domain);
		
		if (currentDomain == null) {
			sessionFactory.getCurrentSession().save(domain);
			return true;
		}
		return false;
	}

	private Domain currentDomain(Domain domain) {
		Domain currentDomain = (Domain) sessionFactory.getCurrentSession()
				.createCriteria(Domain.class)
				.add(Restrictions.eq("domainName", domain.getDomainName()))
				.uniqueResult();
		return currentDomain;
	}

	@Override
	@Transactional
	public boolean deleteDomain(int id) {
		Domain currentDomain = (Domain) sessionFactory.getCurrentSession()
				.createCriteria(Domain.class)
				.add(Restrictions.eq("domainId", id))
				.uniqueResult();
		
		if (currentDomain == null) {
			return false;
		}
		sessionFactory.getCurrentSession().delete(currentDomain);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Domain> getAllDomains() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Domain.class)
				.list();
	}

}
