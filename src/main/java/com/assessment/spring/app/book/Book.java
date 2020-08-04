package com.assessment.spring.app.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.assessment.spring.app.library.Library;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	private String name;
	private String author;
	private Long price;
	@Column(name = "library_Id", nullable=false)
	private Long library_Id;
	
	//@JsonManagedReference
	@ManyToOne
    @JoinColumn(name="library_Id",referencedColumnName="lid",insertable=false, updatable=false)
    private Library library;
	
	public Book() {
		super();
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getLibrary_Id() {
		return library_Id;
	}

	public void setLibrary_Id(Long library_Id) {
		this.library_Id = library_Id;
	}

	@JsonIgnore
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Book(Long bid, String name, String author, Long price, Long library_Id, Library library) {
		super();
		this.bid = bid;
		this.name = name;
		this.author = author;
		this.price = price;
		this.library_Id = library_Id;
		this.library = library;
	}
	
}
