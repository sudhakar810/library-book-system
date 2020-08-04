package com.assessment.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.spring.app.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

}
