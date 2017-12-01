package br.com.library.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {

	@Id
	private Integer id;
	private String title;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfpublication;
	@ManyToOne(fetch = FetchType.EAGER)
	private Author author = new Author();
	@ManyToMany
	private List<Category> categories = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getDateOfpublication() {
		return dateOfpublication;
	}

	public void setDateOfpublication(Calendar dateOfpublication) {
		this.dateOfpublication = dateOfpublication;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
