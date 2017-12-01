package br.com.library.dao;

import javax.persistence.EntityManager;

public abstract class JpaDao<T> implements Dao<T> {

	protected EntityManager em = Connection.geEntityManager(Connection.LIBRARY);

	@SuppressWarnings("rawtypes")
	private Class clazz;

	@SuppressWarnings("rawtypes")
	public JpaDao(Class clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(Integer id) {
		em.getTransaction().begin();
		T t = (T) em.find(clazz, id);
		em.getTransaction().commit();
		em.close();
		return t; 
	}

	@Override
	public void remove(Integer id) {
		em.getTransaction().begin();
		em.remove(find(id));
		em.getTransaction().commit();
		em.close();
	}

}
