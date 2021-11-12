package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// tutorial from https://www.youtube.com/watch?v=9SGDpanrc8U
// this application was created with https://start.spring.io/: default configs and 3 dependencies (spring web, spring data jpa, postgresql driver)
// this application will be structured in 3 layers (nth layer architecture, with Student as a model):
	// - API layer: StudentController class
	// - Service layer (business logic): StudentService class
	// - Data Access Layer (to access database): StudentRepository interface
// to run application: run 'install' task on maven to generate jar, then 'java -jar jarname.jar' (make sure postgresql is running on port 5432)
// optionally, to change port, include --server.port=8081 in the java command
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
