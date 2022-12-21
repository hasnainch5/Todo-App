package com.project.Todo.app.controller;

import com.project.Todo.app.model.Todo;
import com.project.Todo.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    @GetMapping("/todo")
    public List<Todo> fetchAllTodos(){
        return todoService.fetchAllTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") Long todoId){
        return todoService.getTodoById(todoId);
    }

    @GetMapping("/todo/name/{name}")
    public Todo getTodoByName(@PathVariable("name") String todoName) {
        return todoService.getTodoByName(todoName);
    }

    @DeleteMapping("/todo/{id}")
    public String deleteTodoById(@PathVariable("id") Long todoId){
        todoService.deleteTodoById(todoId);
        return "Todo deleted successfully!";
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@PathVariable("id") Long todoId, @RequestBody Todo todo){
        return todoService.updateTodo(todoId,todo);
    }
}

