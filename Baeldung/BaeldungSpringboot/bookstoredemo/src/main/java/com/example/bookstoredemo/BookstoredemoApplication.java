package com.example.bookstoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// tutorial: https://www.baeldung.com/spring-boot-start

// Note that we're using the following:
//
//    @EnableJpaRepositories to scan the specified package for repositories
//    @EntityScan to pick up our JPA entities

@EnableJpaRepositories("com.example.bookstoredemo")
@EntityScan("com.example.bookstoredemo.model")
@SpringBootApplication // equivalent to @Configuration, @EnableAutoConfiguration and @ComponentScan
public class BookstoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoredemoApplication.class, args);
	}

}
