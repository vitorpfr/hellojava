package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.TodoData;
import org.example.model.TodoItem;
import org.example.service.TodoItemService;
import org.example.util.AttributeNames;
import org.example.util.Mappings;
import org.example.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructor ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getTodoData();
    }

    // == handler methods ==

    // good practice: avoid using strings for mappings and views, and prefer storing them as static final fields (constants)
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    // http://localhost:8080/todo-list/add?title=aaa&details=bbb&deadline=2021-12-07
//    @GetMapping(Mappings.ADD)
//    public String add(
//            @RequestParam String title,
//            @RequestParam String details,
//            @RequestParam String deadline) {
//
//        // ideally we would validate that the deadline provided is valid to be parsed, to avoid throwing exception to user
//        todoItemService.addItem(new TodoItem(title, details, LocalDate.parse(deadline)));
//
//        return ViewNames.ITEMS_LIST;
//    }

    // http://localhost:8080/todo-list/addItem
    // this will display the jsp/html with the form to add a new item
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(Model model) {
        TodoItem todoItem = new TodoItem("", "", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    // this method will be called after we submit the form
    // it will extract the form content and add to the attribute todoItem
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(
            // this attribute name needs to match the attribute name specified in the form (jsp file)
            @ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);

        todoItemService.addItem(todoItem);

        return "redirect:/" + Mappings.ITEMS;
    }
}
