package br.com.library.dao;

import java.util.List;

import br.com.library.models.Author;

public class AuthorDao extends JpaDao<Author> {

	public AuthorDao() {
		super(Author.class);
	}
	
	public List<Author> findAll() {
		return em.createQuery("select a from Author a", Author.class).getResultList();
	}

}
