/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.model.*;
import com.example.todo.service.*;

@RestController
public class TodoController {
    @Autowired
    public TodoH2Service tservice;

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        tservice.deleteTodo(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo tobj) {
        return tservice.updateTodo(id, tobj);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo tobj) {
        return tservice.addTodo(tobj);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return tservice.getTodoById(id);
    }

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return tservice.getTodos();
    }

}
