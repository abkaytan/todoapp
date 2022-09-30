package com.coderspace.todoapp.controller;

import com.coderspace.todoapp.dto.TodoDTO;
import com.coderspace.todoapp.entity.Todo;
import com.coderspace.todoapp.exception.UserNotFoundException;
import com.coderspace.todoapp.service.Impl.TodoServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todoapp")
public class TodoController {

    private final TodoServiceImpl todoServiceImpl;

    public TodoController(TodoServiceImpl todoServiceImpl) {
        this.todoServiceImpl = todoServiceImpl;
    }

    @PostMapping("save-todo/{customerId}")
    @ApiOperation(value = "${TodoController.saveTodo}", authorizations = { @Authorization(value="apiKey") })
    public ResponseEntity<Todo> saveTodo (@PathVariable Long customerId , @RequestBody @Valid TodoDTO todoDTO){
        todoServiceImpl.saveToDo(todoDTO, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/todo-list/{customerId}")
    public ResponseEntity<List<Todo>> showTodoList (@Valid @PathVariable Long customerId){
        return  new ResponseEntity<>(todoServiceImpl.getTodoList(customerId), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{customerId}/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long id){
        String result = todoServiceImpl.deleteTodo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
