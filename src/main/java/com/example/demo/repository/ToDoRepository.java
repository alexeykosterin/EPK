package com.example.demo.repository;

import com.example.demo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo, String> {
}