package com.project.Todo.app.service;

import com.project.Todo.app.model.Todo;
import java.util.List;

public interface TodoService {
    Todo saveTodo(Todo todo);

    List<Todo> fetchAllTodos();

    Todo getTodoById(Long todoId);

    void deleteTodoById(Long todoId);

    Todo getTodoByName(String todoName);

    Todo updateTodo(Long todoId, Todo todo);
}
