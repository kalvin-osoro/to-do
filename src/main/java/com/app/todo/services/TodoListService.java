package com.app.todo.services;

import com.app.todo.models.TodoList;
import com.app.todo.payload.request.AddItemRequest;

import java.util.List;
import java.util.Optional;

public interface TodoListService {

    List<TodoList> getAllItems();

    Optional<TodoList> getItem(Long id);
    public Object addItem(AddItemRequest addItemRequest);
}
