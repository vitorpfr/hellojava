package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller annotation is a specialization of the Component annotation that gets scanned for request mapping annotations
@Controller
@Slf4j
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==

    // this can be accessed using http://localhost:8080/todo-list/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {

        // without any other annotation, this is mapped to the view "hello", not the string "hello"
        // adding the @ResponseBody annotation will make the method return the string "hello" to the user
        // therefore, this will return the string "hello" to the user!
        return "hello";
    }

    // this can be accessed using http://localhost:8080/todo-list/welcome?user=Tim&age=31
    @GetMapping("welcome") // forward slash is added automatically
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {

        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model= {}", model);

        // "welcome" string is mapped to a view by the ViewResolver bean created in the config
        // this return will become "/WEB-INF/view/welcome.jsp", which is the view
        // therefore, this will return the view "welcome" to the user, if it exists!
        return "welcome";
    }

    // == model attributes ==

    // another way to add attributes to the model is by annotating a method
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage called");
        return demoService.getWelcomeMessage();
    }
}
