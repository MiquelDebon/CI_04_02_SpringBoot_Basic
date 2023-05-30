
## Spring CRUD projet with H2 / SQL / MongoDB

The CRUD of a 'Fruit' Entity
- int id
- String name
- int quantiKg 

Taking advantage of the JPA specification, you will have to persist in a MongoDB database, following the MVC pattern. To do this, depending on the main package, you will create a package structure, where you will place the classes you need:

```java
// MVC without View
```

- controller
- model.domain(Entity)
- model.service
- model.repository

> Tested with Postman

<br>
<hr>

### References:

- JPA Repository Query -  https://www.bezkoder.com/jpa-repository-query/
### Nivell 1 - H2 Database:
- Githbub: https://github.com/bezkoder/spring-boot-h2-database-crud
- JPA / Hibernate - https://www.baeldung.com/learn-jpa-hibernate
- Youtube video - https://www.youtube.com/watch?v=QuvS_VLbGko
### Nivell 2 - MySQL Database:
- Spring MySQL - https://spring.io/guides/gs/accessing-data-mysql/
### Nivell 3 - MongoDB Database:
- https://www.devglan.com/spring-boot/spring-boot-mongodb-configuration
- https://www.baeldung.com/spring-response-entity
<hr>
<br>

**Object-Relational Mapping (ORM)** is the process of converting Java objects to database tables. In other words, this allows us to interact with a relational database without any SQL. The Java Persistence API (JPA) is a specification that defines how to persist data in Java applications. 

**Hibernate** is one of the most popular Java ORM frameworks in use today. Its first release was almost twenty years ago, and still has excellent community support and regular releases. Additionally, Hibernate is a standard implementation of the JPA specification, with a few additional features that are specific to Hibernate.

<br>

**JPA is a specification** which specifies how to access, manage and persist information/data between java objects and relational databases. It provides a standard approach for ORM, Object Relational Mapping. Spring Boot provides a seemless integration with JPA.

<p>Hibernate is an open source object relational mapping (ORM) tool that provides a framework to map object-oriented domain models to relational databases for web applications. Object relational mapping is based on the containerization of objects and the abstraction that provides that capacity.</p>
<p><b>Spring Data JPA SQL DEPENDENCY <br>
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.</b></p>
