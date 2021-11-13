package com.example.demo;

// this is a Spring Data JPA repository (extends JPARepository, which extends PagingAndSortingRepository, which extends CrudRepository)
// it is the data access layer of the application
// the goal of this abstraction is to significantly reduce the amount of boilerplate code required to implement data access layers for various persistence stores

import org.springframework.data.jpa.repository.JpaRepository;

// Long is the data type/class of the Student's id parameter (primary key)
public interface StudentRepository extends JpaRepository<Student, Long> {

}
