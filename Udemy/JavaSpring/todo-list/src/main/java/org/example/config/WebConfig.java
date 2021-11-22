package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableWebMvc // used in configuration classes to import MVC configuration, registering beans specific to Spring MVC
public class WebConfig {

}
