package br.com.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	
	public static final String LIBRARY = "mysql_library"; 
	
	private static EntityManagerFactory emf;
	
	public static EntityManager geEntityManager(String persistenceUnitName) {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		return emf.createEntityManager();
	}
	
}
