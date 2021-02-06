package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/* 1. Annotates a class as a Spring Boot application */
@SpringBootApplication
public class DemoApplication {

	/* 2. Start with the Spring Boot Application */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

/* 3. A plain JPA entity to model a Cat entity. */
@Entity
class Cat {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	Cat() {
	}

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat{" + "id=" + id + ", name='" + name + '\'' + "}";
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}

/*
 * 4. A Spring Data JPA repository (which handles all common
 * create-read-update-and-delete operations) that has been exported as a REST
 * API
 */
@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> {
}

/* web browsers localhost:8080/cats
{
  "_embedded" : {
    "cats" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/cats"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/cats"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
}
*/