package com.desafio_todolist.desafio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.desafio_todolist.desafio.entity.Todo;
import com.desafio_todolist.desafio.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo) {
        todoService.create(todo);
        return todoService.list();
    }
    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }
    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        todoService.update(todo);
        return todoService.list();
    }
    @DeleteMapping("/{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return todoService.list();
    }
}