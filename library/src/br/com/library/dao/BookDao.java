package br.com.library.dao;

import java.util.List;

import br.com.library.models.Book;

public class BookDao extends JpaDao<Book> {

	public BookDao() {
		super(Book.class);
	}

	public List<Book> findAll() {
		return em.createQuery("select b from Book b", Book.class).getResultList();
	}

}
