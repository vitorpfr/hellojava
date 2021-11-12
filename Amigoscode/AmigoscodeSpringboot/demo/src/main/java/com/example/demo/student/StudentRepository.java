package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// this is the layer used to communicate with the database
// it extends JpaRepository, which needs to specify two classes: the entity model (Student) and the id class (Long)
// this interface is used in the service via dependency injection to access the database

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // this annotation implements the SQL query on this method (important: Student is the class/Entity, not the table)
    // SELECT * FROM student WHERE email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
