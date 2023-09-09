package com.app.todo.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "todo-items")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String description;

    public TodoList() {

    }
}
