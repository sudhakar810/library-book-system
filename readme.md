# library-book-system
Spring Boot and JPA

## Overview
This project is done using Spring Boot web application using JPA

## Run the Application
## Prerequistes
1. Install Eclipse/STS
2. In memory database H2
3. Use data.sql file to insert data in H2 available in resource folder

### H2 DataBase Connection
In the folder src/main/resources/application.properties, config your database url, username and password correctly.

### Start the Application
1. Import project as maven project
2. When the dependencies specified in the file pom.xml are automatically downloaded , run the application.
3. Right click on LibraryAndBookApplication.java class and run as Java Application 


## EndPoints
####Library Service APIs

1. GET - http://localhost:8080/libraries
2. GET - http://localhost:8080/libraries/{id}<br />
			  example:http://localhost:8080/libraries/1
3. DELETE - http://localhost:8080/libraries/{id}<br />
			  example:http://localhost:8080/libraries/1 
4. POST - http://localhost:8080/libraries <br/>
          Library object as payload
5. PUT - http://localhost:8080/libraries/{id} <br/>
           example:http://localhost:8080/libraries/1
           Library objectas payload

####Book Service APIs
1. GET - http://localhost:8080/books
2. GET - http://localhost:8080/books/{id}<br />
			  example:http://localhost:8080/books/1
4. DELETE - http://localhost:8080/books/{id}<br />
			  example:http://localhost:8080/books/1 
5. POST - http://localhost:8080/books <br/>
          Book object as payload
6. PUT - http://localhost:8080/books/{id} <br/>
           example:http://localhost:8080/books/1
           Book objectas payload

