// Write your code here
package com.example.todo.model;

public class Todo {
    private int id;
    private String todo;
    private String status;
    private String priority;

    public Todo(int id, String todo, String status, String priority) {
        this.id = id;
        this.todo = todo;
        this.status = status;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return this.todo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return this.priority;
    }
}