package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // create context (Spring container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get a cached instance of the singleton bean instance that was instantiated (there's only one there)
        // in other words: get number generator bean from context
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // call reset method
        // not needed here because this method was added to the bean lifecycle (called automatically on Game bean startup)
//        game.reset();

        // close context (Spring container)
        context.close();
    }
}
