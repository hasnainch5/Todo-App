package com.project.Todo.app.serviceImpl;

import com.project.Todo.app.model.Todo;
import com.project.Todo.app.repository.TodoRepository;
import com.project.Todo.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> fetchAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long todoId) {
        Optional<Todo> optionalTodo = this.todoRepository.findById(todoId);
        if (optionalTodo.isPresent()) return optionalTodo.get();
        throw new RuntimeException("Todo with ID: " + todoId + " does not exists");
    }

    @Override
    public void deleteTodoById(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public Todo getTodoByName(String todoName) {
        return todoRepository.findByTodoName(todoName);
    }

    @Override
    public Todo updateTodo(Long todoId, Todo todo) {
        Todo updatedTodo = todoRepository.findById(todoId).get();

        if (Objects.nonNull(todo.getTodoName()) &&
                !"".equalsIgnoreCase(todo.getTodoName())) {
            updatedTodo.setTodoName(todo.getTodoName());
        }

        if (Objects.nonNull(todo.getTodoBody()) &&
                !"".equalsIgnoreCase(todo.getTodoBody())) {
            updatedTodo.setTodoBody(todo.getTodoBody());
        }

        return todoRepository.save(updatedTodo);
    }
}
