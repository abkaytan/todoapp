package com.coderspace.todoapp.service;


import com.coderspace.todoapp.dto.TodoDTO;
import com.coderspace.todoapp.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    public void saveToDo(TodoDTO todoDTO, Long id);
    public List<Todo> getTodoList(Long customerId);
    String deleteTodo(Long id);
//    String deleteTodo(Long customerId, Long id);
    /*public Optional<List<Todo>> getTodoList(Long customerId);*/
}
