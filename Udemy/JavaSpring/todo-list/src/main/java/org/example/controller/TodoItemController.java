package org.example.controller;

import lombok.NonNull;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    // http://localhost:8080/todo-list/addItem
    // or
    // http://localhost:8080/todo-list/addItem?id=5
    // this will display the jsp/html with the form to add a new item

    // id parameter is marked as optional because it is not needed on item addition (only on edition)
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(
            @RequestParam(required = false, defaultValue = "-1") int id,
            Model model) {

        boolean isItemAddition = id == -1;
        TodoItem todoItem;

        if (isItemAddition) {
            log.info("moving to add item page");
            todoItem = new TodoItem("", "", LocalDate.now());
        } else {
            log.info("editing id = {}", id);
            todoItem = todoItemService.getItem(id);
        }

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

        boolean isItemAddition = todoItem.getId() == 0;
        if (isItemAddition) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam @NonNull int id) {
        log.info("Call deleteItem for id = " + id);
        todoItemService.removeItem(id);

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam @NonNull int id, Model model) {

        TodoItem todoItem = todoItemService.getItem(id);
        boolean itemExists = todoItem != null;

        if (!itemExists) {
            throw new IllegalArgumentException("Provided item does not exist in the database!");
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }
}
