package com.desafio_todolist.desafio.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Sort;
import com.desafio_todolist.desafio.repository.TodoRepository;
import com.desafio_todolist.desafio.entity.Todo;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }
    @GetMapping
    public List<Todo> list() {
        Sort sort = Sort.by(Sort.Order.desc("prioridade"), Sort.Order.asc("nome"));
        return todoRepository.findAll(sort);
    }
    @PutMapping
    public List<Todo> update(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return list();
    }
    @DeleteMapping("/{id}")
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }}
