package org.example.console;

import org.example.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // create context (Spring container)
        // below is the line that starts Spring, which will manage the application lifecycle, components, etc

        // there are two ways to initialize spring:
        // 1: using a xml config file:
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 2: using a Config class file (annotated with @Configuration and @ComponentScan)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // no need for other commands here because ConsoleNumberGuess class listens to the application ready event and starts the game

        // close context (Spring container)
        context.close();
    }
}
