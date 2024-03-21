// Write your code here
package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.*;

public interface TodoRepository {
    void deleteTodo(int id);

    Todo updateTodo(int id, Todo tobj);

    Todo addTodo(Todo tobj);

    Todo getTodoById(int id);

    ArrayList<Todo> getTodos();

}