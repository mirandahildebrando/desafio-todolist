package com.desafio_todolist.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio_todolist.desafio.entity.Todo;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByRealizado(boolean realizado);

    List<Todo> findByPrioridade(int prioridade);

    List<Todo> findByNameContaining(String name);

    List<Todo> findByDescricaoContaining(String descricao);
}