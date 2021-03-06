package net.sytes.codeline.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sytes.codeline.dao.DomainDao;
import net.sytes.codeline.dao.DomainDaoImpl;
import net.sytes.codeline.dao.MessagesDao;
import net.sytes.codeline.dao.MessagesDaoImpl;
import net.sytes.codeline.dao.UserDao;
import net.sytes.codeline.dao.UserDaoImpl;
import net.sytes.codeline.entities.Domain;
import net.sytes.codeline.entities.Messages;
import net.sytes.codeline.entities.User;

/**
 * @author Dusan Nesic
 * Spring config class
 * Defines database connections, and sessionFactory
 * along with bean definitions
 */
@Configuration
@ComponentScan("net.sytes.codeline")
@EnableTransactionManagement
public class ApplicationContextConfig {

	/**
	 * Method getDataSource
	 * Defines the database, driver usage, and connection credentials
	 * 
	 * @return - DataSource - database info
	 */
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/chatster");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.addConnectionProperty("useUnicode", "yes");
		dataSource.addConnectionProperty("characterEncoding", "UTF-8");
		return dataSource;
	}
	
	/**
	 * Method getSessionFactory
	 * Defines SessionFactory, and which entities are used as beans
	 * 
	 * @param dataSource - specifies which database is used
	 * @return - SessionFactory - preset sessionFactory
	 */
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Domain.class, User.class, Messages.class);
		sessionBuilder.addProperties(getHibernateProperties());
		
		return sessionBuilder.buildSessionFactory();
	}
	
	/**
	 * Method getHibernateProperties
	 * Returns Properties out of hibernate properties
	 * 
	 * @return - Properties - preset Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "false");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hbm2ddl.auto", "create");
		properties.put("hibernate.id.new_generator_mappings", "false");
		
		return properties;
	}
	
	/**
	 * Method getTransactionManager
	 * Setting up the TransactionManager
	 * 
	 * @param sessionFactory - passing the already defined SessionFactory
	 * @return - HibernateTransactionManager - preset component
	 */
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	/**
	 * Demo method of creating beans
	 */
	@Autowired
	@Bean(name="domainDao")
	public DomainDao getDomainDao(SessionFactory sessionFactory) {
		return new DomainDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="messagesDao")
	public MessagesDao getMessagesDao(SessionFactory sessionFactory) {
		return new MessagesDaoImpl(sessionFactory);
	}

}
