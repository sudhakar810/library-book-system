package com.assessment.spring.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.spring.app.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
