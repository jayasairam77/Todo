/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpStatus;
import java.util.*;
import com.example.todo.model.*;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoH2Service implements TodoRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public void deleteTodo(int id) {
        db.update("delete from todolist where id=?", id);
    }

    @Override
    public Todo updateTodo(int id, Todo tobj) {
        if (tobj.getTodo() != null)
            db.update("update todolist set todo=? where id=?", tobj.getTodo(), id);
        if (tobj.getPriority() != null)
            db.update("update todolist set priority=? where id=?", tobj.getPriority(), id);
        if (tobj.getStatus() != null)
            db.update("update todolist set status=? where id=?", tobj.getStatus(), id);
        return getTodoById(id);
    }

    @Override
    public Todo addTodo(Todo tobj) {
        db.update("insert into todolist(todo,priority,status) values(?,?,?)", tobj.getTodo(), tobj.getPriority(),
                tobj.getStatus());
        Todo stodo = db.queryForObject("select * from todolist where todo=? and priority=? and status=?",
                new TodoRowMapper(), tobj.getTodo(), tobj.getPriority(), tobj.getStatus());
        return stodo;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            Todo obj = db.queryForObject("select * from todolist where id = ?", new TodoRowMapper(), id);
            return obj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> todol = db.query("select * from todolist", new TodoRowMapper());
        ArrayList<Todo> rtodo = new ArrayList<>(todol);
        return rtodo;
    }

}
