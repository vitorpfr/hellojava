package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// course link: https://www.youtube.com/watch?v=8SGI_XS5OPw&t=455
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // this creates a functional interface (interface w/ only one method) that runs the lambda on application startup
    // Bean annotation makes spring execute this method on startup
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student("Maria", "Jones", "maria.jones@gmail.com", 21);
            studentRepository.save(maria);
        };
    }

}
