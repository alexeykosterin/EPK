package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.validator.ToDoValidationError;
import com.example.demo.validator.ToDoValidationErrorBuilder;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ToDoController {
    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todo")
    public ResponseEntity<Iterable<Todo>> getToDos() {
        return ResponseEntity.ok(toDoRepository.findAll());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getToDoById(@PathVariable String id) {
        Optional<Todo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent())
            return ResponseEntity.ok(toDo.get());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ToDoValidationError handleException(Exception exception) {
        return new ToDoValidationError(exception.getMessage());
    }
}