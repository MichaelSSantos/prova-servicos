package br.com.library.dao;

import java.util.List;

import br.com.library.models.Category;

public class CategoryDao extends JpaDao<Category> {

	public CategoryDao() {
		super(Category.class);
	}
	
	public List<Category> findAll() {
		return em.createQuery("select c from Category c", Category.class).getResultList();
	}
	
}
