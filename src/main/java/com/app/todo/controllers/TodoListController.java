package com.app.todo.controllers;

import com.app.todo.models.TodoList;
import com.app.todo.payload.request.AddItemRequest;
import com.app.todo.payload.response.MessageResponse;
import com.app.todo.services.TodoListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TodoListController {

    private final TodoListService todoListService;

//   get all items
    @GetMapping("/")
    public ResponseEntity<List<TodoList>> getAllItems() {
        List<TodoList> todoList = todoListService.getAllItems();
        return new ResponseEntity<>(todoList,HttpStatus.OK);
    }


    @PostMapping("/add-item")
    public ResponseEntity<?> addItem(@RequestBody AddItemRequest addItemRequest) {

        MessageResponse response = (MessageResponse) todoListService.addItem(addItemRequest);
        return ResponseEntity.ok(response);



    }

}
