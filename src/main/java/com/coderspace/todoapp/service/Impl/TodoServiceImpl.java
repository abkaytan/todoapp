package com.coderspace.todoapp.service.Impl;

import com.coderspace.todoapp.dto.TodoDTO;
import com.coderspace.todoapp.entity.Customer;
import com.coderspace.todoapp.entity.Todo;
import com.coderspace.todoapp.exception.CustomException;
import com.coderspace.todoapp.exception.UserNotFoundException;
import com.coderspace.todoapp.repository.CustomerRepository;
import com.coderspace.todoapp.repository.TodoRepository;
import com.coderspace.todoapp.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void saveToDo(TodoDTO todoDTO, Long customerId) {

        Todo todo = new Todo();

        todo.setTask(todoDTO.getTask());
        todo.setDescription(todoDTO.getDescription());
        todo.setAdditionDate(todoDTO.getAdditionDate());
        todo.setDeadLine(todoDTO.getDeadLine());
        todo.setCustomerId(customerId);

        todoRepository.save(todo);

    }

    @Override
    public List<Todo> getTodoList(Long customerId) {
        return todoRepository.findAllByCustomerId(customerId);
    }

    @Override
    public String deleteTodo(Long id) {
        try {
            todoRepository.deleteById(id);
//            todoRepository.deleteByCustomerIdAndId(customerId, id);
        } catch (Exception e){throw new CustomException("delete operatin can not be applied");}
        return "delete operation is successful";
    }
}
