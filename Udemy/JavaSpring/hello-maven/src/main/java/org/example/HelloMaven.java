package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMaven {
    private static final Logger log = LoggerFactory.getLogger(HelloMaven.class);

    // There are two components for logging: API (interface that the developer uses to log) and implementation (actual code that logs)

    // We'll be using logback and sfl4j libraries for logging:
    // - sfl4j provides the API for the developer
    // - logback is the most modern/recommended implementation and is compatible with the sfl4j interfaces/API

    // Logback has a waterfall of config: logback-test.xml, etc - if none is provided, the default logging configuration
    // is defined, and sends logs to console
    // if you want to configure logback, create an xml file in the resources folder (see example: resources/logback.xml)

    // example of logging pattern and the conversion:
    // 2017-12-12 23:28:16.698 [main] DEBUG org.example.HelloMaven - Hello Debug
    // %date [%thread] %-5level %logger{40} - %message%n

    public static void main(String[] args) {
//        System.out.println("Hello Maven"); // not the recommended way of logging

        // this is being logged according to resources/logback.xml configuration
        log.info("Hello Info");
        log.debug("Hello Debug");

    }
}
