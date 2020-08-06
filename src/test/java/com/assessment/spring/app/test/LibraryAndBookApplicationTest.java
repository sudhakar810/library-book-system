package com.assessment.spring.app.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assessment.spring.app.model.Book;
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class LibraryAndBookApplicationTest extends AbstractTest{

	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Test
	   @Order(1)
	   public void getBookList() throws Exception {
	      String uri = "/books";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      List<Book> bookList = super.mapFromJson(content, List.class);
	      assertTrue(bookList.size() > 0);
	   }
	   
	   
	   @Test
	   @Order(2)
	   public void createBook() throws Exception {
	      String uri = "/books";
	      Book book = new Book();
	      book.setBid((long) 10004);
	      book.setAuthor("test");
	      book.setLibrary_Id((long) 1);
	      book.setPrice((long) 1200);
	      String inputJson = super.mapToJson(book);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertTrue(Boolean.parseBoolean(content), "Book is created successfully");
	   }
	   
	   @Test
	   @Order(3)
	   public void updateBook() throws Exception {
	      String uri = "/books/10003";
	      Book book = new Book();
	      book.setPrice((long) 1200);
	      book.setLibrary_Id((long) 1);
	      String inputJson = super.mapToJson(book);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertTrue(Boolean.parseBoolean(content), "Book is updated successsfully");
	   }
	   @Test
	   @Order(4)
	   public void deleteBook() throws Exception {
	      String uri = "/books/10003";
	      Boolean isDeleted = false;
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  isDeleted = true;
	      }
	    //  String content = mvcResult.getResponse().getContentAsString();
	      assertTrue(isDeleted, "Book is deleted successsfully");
	   }

}
