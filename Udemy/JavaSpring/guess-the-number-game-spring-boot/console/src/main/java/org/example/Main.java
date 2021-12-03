package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        ///// old way: initializing project using Spring context dependency
//
//        // create context (Spring container)
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        // no need for other commands here because ConsoleNumberGuess class listens to the application ready event and starts the game
//        // close context (Spring container)
//        context.close();


        ///// new way: initializing project using Spring boot

        // with spring boot, there's no need to create the context manually - it is done automatically
        SpringApplication.run(Main.class, args);
    }
}
