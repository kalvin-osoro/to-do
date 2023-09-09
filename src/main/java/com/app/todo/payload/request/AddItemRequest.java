package com.app.todo.payload.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class AddItemRequest {

    @NonNull
    private String title;

    @NonNull
    private String description;
}
