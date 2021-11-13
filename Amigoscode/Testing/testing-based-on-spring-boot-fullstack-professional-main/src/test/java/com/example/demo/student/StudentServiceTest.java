package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

// if you add ExtendWith mockito class, you don't need to declare autoCloseable, openMocks and then close
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    // we know that StudentRepository is tested and it works (on its own test file)
    // therefore, we don't need to spin a new StudentRepository/database to test StudentService
    // we can mock studentRepository here to focus on testing StudentService
    // how to do it:
    // - insert @Mock annotation in the field you want to mock
    // - add an AutoClosable field, setup before each test with .openMocks(this), teardown after each test with .close()
    // optionally you can add @ExtendWith(MockitoExtension.class) to the class which does all the AutoCloseable stuff under the hood

    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        // reminder: cmd+option+v = transforms the current statement in a variable declaration
        underTest = new StudentService(studentRepository);
    }

    // this tests that when I call getAllStudents in the StudentService, .findAll was called in studentRespository (mocked)
    @Test
    void canGetAllStudents() {
        // when
        underTest.getAllStudents();

        // then
        verify(studentRepository).findAll();
    }

//    @Disabled // this test won't run with this annotation
    @Test
    void addStudent_canAddStudent() {
        // given
        String email = "jamila@gmail.com";
        Student student = new Student("Jamila", email, Gender.FEMALE);

        // when
        underTest.addStudent(student);

        // then (all of the below checks if the student we passed to the function is the one that was passed to studentRepository.save (our mocked field))
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class); // creates a captor
        verify(studentRepository).save(studentArgumentCaptor.capture()); // verifies that save was called and saves the student passed as an arg
        Student capturedStudent = studentArgumentCaptor.getValue(); // gets the value of the student passed
        assertEquals(capturedStudent, student); // checks that student was passed to function

    }

    @Test
    void addStudent_willThrowWhenEmailIsTaken() {
        // given
        String email = "jamila@gmail.com";
        Student student = new Student("Jamila", email, Gender.FEMALE);
        given(studentRepository.selectExistsEmail(email)).willReturn(true); // you can also pass anyString() instead of email

        // when/then
        assertThatThrownBy(() -> underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository, never()).save(any());
    }

    @Test
    void deleteStudent_canDeleteStudent() {
        // given
        Long studentId = 34L;
        given(studentRepository.existsById(studentId)).willReturn(true); // this is mocked because we don't need to test StudentRepository functionality here

        // when
        underTest.deleteStudent(studentId);

        // then
        verify(studentRepository).deleteById(studentId);
    }

    @Test
    void deleteStudent_willThrowWhenStudentDoesNotExist() {
        // given
        Long studentId = 34L;
        given(studentRepository.existsById(studentId)).willReturn(false); // this is mocked because we don't need to test StudentRepository functionality here

        // when-then
        assertThatThrownBy(() -> underTest.deleteStudent(studentId))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("Student with id " + studentId + " does not exists");

        verify(studentRepository, never()).delete(any());
    }
}