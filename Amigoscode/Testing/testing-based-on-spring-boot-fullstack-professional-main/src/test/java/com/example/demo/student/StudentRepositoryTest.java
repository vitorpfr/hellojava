package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// this file can be auto-created with putting cursor on class/interface, option-return, Create Tests
// another option: cmd+shift+T inside the class/interface (also navigates to its test)

// this annotation is responsible for auto-wiring the repository and using test properties file
@DataJpaTest
public class StudentRepositoryTest {

    // spring annotation that auto-injects a instance of StudentRepository in this field when running
    // issue: if we run this as-is, the test will try to use the production database (PostgreSQL)
    // ideally, we want to use an in-memory database for testing (H2), which was added to pom.xml to be used

    // we need to add an application.properties in a resources folder under 'test' folder, which will be the test configs for the application (ex: connect to h2 database instead of postgresql)

    // important: we don't need to create general SQL table setup, teardown, etc, all because JPA does it for us (spring.jpa.hibernate.ddl-auto=create-drop config creates and deletes everything)
    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll(); // just deletes all data before each test
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        // given
        String email = "jamila@gmail.com";
        Student student = new Student("Jamila", email, Gender.FEMALE);
        underTest.save(student);

        // when
        Boolean exists = underTest.selectExistsEmail(email);

        // then
        assertThat(exists).isTrue(); // using assertj
        assertTrue(exists); // using junit assertions class
    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExist() {
        // given
        String email = "jamila@gmail.com";

        // when
        Boolean exists = underTest.selectExistsEmail(email);

        // then
        assertThat(exists).isFalse(); // assertj option
        assertFalse(exists); // junit option
    }

    // important: underTest has a bunch of other methods (save, delete, findById, etc) that are inherited from JpaRepository interface
    //            we don't need to unit test those methods, since we didn't write them (they were already tested by JPA)
}