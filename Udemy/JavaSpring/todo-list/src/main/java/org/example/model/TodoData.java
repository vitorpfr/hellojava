package org.example.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// this class simulates an in-memory database, holding data in an ArrayList

// steps to make this class immutable:
// - items list is final, so it cannot be reassigned
// - getItems method returns an unmodifiable list, so changes on it are not allowed

public class TodoData {
    // == fields ==
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    // == constructor ==
    public TodoData() {
        // add some dummy data, using the addItem method so it sets the id field
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth details", LocalDate.now()));
    }

    // == public methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        // this can be substituted by the @NonNull annotation provided by Lombok! it is boilerplate code
//        if (toAdd == null) {
//            throw new NullPointerException("toAdd is a required parameter.");
//        }

        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id) {
        // using a ListIterator is a way to scan through a list and also easily manipulate current element
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.equals(toUpdate)) {
                itemIterator.set(toUpdate); // sets the current element of the iterator
                break;
            }
        }
    }
}
