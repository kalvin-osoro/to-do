package com.app.todo.services.impl;

import com.app.todo.models.TodoList;
import com.app.todo.payload.request.AddItemRequest;
import com.app.todo.repository.TodoListRepository;
import com.app.todo.services.TodoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    @Override
    public List<TodoList> getAllItems() {

        return todoListRepository.findAll();
    }

    @Override
    public Optional<TodoList> getItem(Long id) {

        Optional<TodoList> todoList = todoListRepository.findById(id);

        return todoList;

    }

    @Override
    public Object addItem(AddItemRequest addItemRequest) {

        TodoList todoList = new TodoList();
        todoList.setTitle(addItemRequest.getTitle());
        todoList.setDescription(addItemRequest.getDescription());

       return todoListRepository.save(todoList);

    }

    @Override
    public TodoList editProduct(Long id, AddItemRequest addItemRequest) throws Exception {

        Optional<TodoList> todoList = todoListRepository.findById(id);
        if (!todoList.isPresent()) {
            throw new Exception("Item does not exist");
        }
        TodoList editItem = todoList.get();
        editItem.setTitle(addItemRequest.getTitle());
        editItem.setDescription(addItemRequest.getDescription());

        return todoListRepository.save(editItem);

    }

    @Override
    public void deteleItem(Long id) {

        Optional<TodoList> optionalTodoListItem = todoListRepository.findById(id);

        if (optionalTodoListItem.isEmpty()) {

            throw new RuntimeException("Item with id "+ id + "does not exist!");
        }
        TodoList todoListItem = optionalTodoListItem.get();

        todoListRepository.delete(todoListItem);

    }


}
