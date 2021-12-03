package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class) // this allows for modularized configuration, and it is a good practice - it imports all the beans from this class
@ComponentScan(basePackages = "org.example") // this scans components even in other modules with the same base package
public class AppConfig {

    // declaring bean methods such as below are not necessary bc we are using @Component (on classes) and @ComponentScan here
    // == bean methods ==
//    @Bean
//    public NumberGenerator numberGenerator() {
//        return new NumberGeneratorImpl();
//    }
//
//    @Bean
//    public Game game() {
//        return new GameImpl();
//    }
//
//    @Bean
//    public MessageGenerator messageGenerator() {
//        return new MessageGeneratorImpl();
//    }
}
