package br.com.library.dao;

public interface Dao<T> {

	void create(T entity);

	void update(T entity);

	T find(Integer id);
	
	void remove(Integer id);

}
