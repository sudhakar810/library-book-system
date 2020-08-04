package com.assessment.spring.app.library;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.assessment.spring.app.book.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lid")
	private Long lid;
	private String name;
	private String department;
	
	//@JsonBackReference
	@OneToMany(mappedBy = "library")
    private List<Book> books;
	
	
	public Library() {
		
	}


	public Library(Long lid, String name, String department, List<Book> books) {
		super();
		this.lid = lid;
		this.name = name;
		this.department = department;
		this.books = books;
	}



	public Long getLid() {
		return lid;
	}


	public void setLid(Long lid) {
		this.lid = lid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	
	
	
		
}
