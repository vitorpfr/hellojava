package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service // @Component would also work, but @Service is better for readability - marks this as a Service class
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // this annotation injects a new instance of StudentRepository dependency automatically on start
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        // the studentRepository is the component responsible for accessing the database
        // it has several built-in methods: findById, getOne, deleteById, etc

        // findAll() method returns a list; SpringBoot already converts this list back to JSON in client response
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("E-mail is already taken");
        }

        // ideally we would need to check if e-mail address is valid here before saving it to the database

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }

        studentRepository.deleteById(studentId);
    }

    // transactional annotation handles updating entities in the database
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> {
            throw new IllegalStateException("Student " + studentId + " does not exist");
        });

        if ((name != null) && (name.length() > 0) && (!student.getName().equals(name))) {
            student.setName(name);
        }

        // possible bug: if e-mail is already taken, is the name also updated? shouldn't this change be atomic?
        // answer: no, the bug does not happen - @Transactional annotation does everything inside method as a transaction atomically (either all changes happen, or none)
        if ((email != null) && (email.length() > 0) && (!student.getEmail().equals(email))) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("e-mail provided is already taken");
            }
            student.setEmail(email);
        }
    }
}
