package com.app.todo.controllers;

import com.app.todo.models.TodoList;
import com.app.todo.payload.request.AddItemRequest;
import com.app.todo.payload.response.MessageResponse;
import com.app.todo.repository.TodoListRepository;
import com.app.todo.services.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TodoListController {

    private final TodoListService todoListService;
    private final TodoListRepository todoListRepository;

//   get all items
    @GetMapping("/")
    public ResponseEntity<List<TodoList>> getAllItems() {
        List<TodoList> todoList = todoListService.getAllItems();
        return new ResponseEntity<>(todoList,HttpStatus.OK);
    }

    //    get item with id
    @GetMapping("/get-item/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        try {
            // Call the service to retrieve the item by ID
            Optional<TodoList> todoList = todoListService.getItem(id);

            if (todoList.isPresent()) {
                // Return a success response with the found TodoList
                return ResponseEntity.ok(todoList.get());
            } else {
                // Return a not found response if the item is not present
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MessageResponse("Item with ID " + id + " not found"));
            }
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Failed to retrieve item: " + e.getMessage()));
        }
    }

    @PostMapping("/add-item")
    public ResponseEntity<?> addItem(@RequestBody AddItemRequest addItemRequest) {

        if (todoListRepository.existsByTitle(addItemRequest.getTitle())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Item already exists!"));
        }
        try {
            // Call the service to add the item to the database
            TodoList todoList = (TodoList) todoListService.addItem(addItemRequest);

            // Construct a success response with the TodoList
            MessageResponse response = new MessageResponse("Item added successfully!");

            // Return a success response with the TodoList
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Failed to add item: " + e.getMessage()));
        }

    }

    @PostMapping("/update/{itemId}")
    public ResponseEntity<?> editItem(@PathVariable("itemId") Long itemId,
                                      @RequestBody AddItemRequest addItemRequest) throws Exception {

//        if (todoListRepository.existsByTitle(addItemRequest.getTitle())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Item already exists!"));
//        }

        try {

            // Call the service to retrieve the item by ID
            Optional<TodoList> todoList = todoListService.getItem(itemId);

            if (todoList.isPresent()) {

                TodoList todoList1 = todoListService.editProduct(itemId, addItemRequest);

                MessageResponse response = new MessageResponse("Item with id "+ itemId + " updated successfully!");

                return ResponseEntity.status(HttpStatus.OK).body(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MessageResponse("Item with ID " + itemId + " does not exist found"));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Failed to update item!"));
        }
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable ("itemId") Long itemId) {

        try {
            // Call the service to retrieve the item by ID
            Optional<TodoList> todoList = todoListService.getItem(itemId);

            if (todoList.isPresent()) {
                // Return a success response with the found TodoList

                todoListService.deteleItem(itemId);

                return new ResponseEntity<>(new MessageResponse("Item with id "+ itemId +  " has been deleted"), HttpStatus.OK);

            } else {
                // Return a not found response if the item is not present
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MessageResponse("Item with ID " + itemId + " not found"));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Failed to update item!"));
        }

     }
}
