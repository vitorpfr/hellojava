package org.example.service;

import lombok.Getter;
import org.example.model.TodoData;
import org.example.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // this is simulating a database
    @Getter
    private final TodoData todoData = new TodoData();

    @Override
    public void addItem(TodoItem toAdd) {
        todoData.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoData.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        todoData.updateItem(toUpdate);
    }
}
