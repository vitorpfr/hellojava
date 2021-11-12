package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// the @RestController annotation was added by us, and makes this class serve REST endpoints (annotated with @GetMapping) -
// with it, spring boot maps it to serve HTTP requests
// the @RequestMapping annotation controls the path of the api
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    // StudentService is a component that needs to be injected into StudentController
    private final StudentService studentService;

    // Autowired annotation makes the studentService automatically instantiated and passed on this constructor (dependency injection)
    // for this to work, the StudentService class needs to be annotated with @Component or @Service (much like clojure's components library)
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // the annotation gets the number from the path (ex: api/v1/student/1) and binds 1 to studentId
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
