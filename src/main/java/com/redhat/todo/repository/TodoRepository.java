package com.redhat.todo.repository;

import java.util.List;

import com.redhat.todo.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

    public List<Todo> getByCompleted(Boolean completed);
    
}