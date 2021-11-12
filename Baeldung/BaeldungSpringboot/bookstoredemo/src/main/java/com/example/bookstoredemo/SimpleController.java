package com.example.bookstoredemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// this Controller annotation denotes to Spring Boot that this class handles the routes/incoming requests
@Controller
public class SimpleController {
    // this is an example of injecting a config value into the application, which is then used in the user response
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home"; // mapped to home.html on templates folder
    }

}
